package com.example.demo.controller;

import com.example.demo.domain.Genre;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class GenreController {

    @Autowired
    GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @RequestMapping("/genre/list")
    public ModelAndView genresList(){
        ModelAndView modelAndView = new ModelAndView("genres");
        List<Genre> genres = genreService.findAll();
        modelAndView.addObject("genres", genres);
        return modelAndView;
    }


    @RequestMapping("/genre/new")
    public String newGenre(Model model) {
        model.addAttribute("genre", new Genre());
        List<Genre> genresAll = genreService.findAll();

        model.addAttribute("genresAll", genresAll);

        return "genreform";
    }

    @RequestMapping("/genre/update")
    public String updateGenre(Model model) {
      //  model.addAttribute("genre", new Genre());
      //  List<Genre> genresAll = genreService.findAll();

       // model.addAttribute("genresAll", genresAll);
        //genreService.update(model);
        return "genreform";
    }

    @PostMapping("/genre")
    public String saveOrUpdate(@Valid @ModelAttribute Genre genre, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "genreform";
        }
        Genre savedGenre = genreService.save(genre);
        return "redirect:/genre/list";
    }

    @RequestMapping("/genre/delete/{id}")
    public String deleteById(@PathVariable String id){
        genreService.deleteById(Long.valueOf(id));
        return "redirect:/genre/list";
    }


}
