package com.example.demo.controller;

import com.example.demo.domain.Genre;
import com.example.demo.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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



   /* @RequestMapping("{/home}")
    public String getGenresPage(Model model,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Genre> genrePage = genreService.findPaginated(PageRequest.of(currentPage-1, pageSize));
        model.addAttribute("genrePage",genrePage);

        return "indexpage";
    }*/


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

    @GetMapping("/genres")
    public String viewHomePage(Model model){
        return findPaginated(1,model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,Model model){

        int pageSize = 5;
        Page<Genre> page = genreService.findPaginated(pageNo,pageSize);
        List<Genre> listGenres = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listGenres", listGenres);

        return "listGenres";

    }



/*
    @RequestMapping(value = "/listGenres", method = RequestMethod.GET)
    public String listGenres(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Genre> genrePage = genreService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("genrePage", genrePage);

        int totalPages = genrePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "listGenres";
    }*/

}
