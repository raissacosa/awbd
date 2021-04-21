package com.example.demo.controller;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Genre;
import com.example.demo.domain.Hall;
import com.example.demo.service.CinemaService;
import com.example.demo.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HallController {

    @Autowired
    HallService hallService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @RequestMapping("/hall/list")
    public ModelAndView productsList(){
        ModelAndView modelAndView = new ModelAndView("halls");
        List<Hall> halls = hallService.findAll();
        modelAndView.addObject("halls",halls);
        return modelAndView;
    }

    @RequestMapping("/hall/new")
    public String newGenre(Model model) {
        model.addAttribute("hall", new Hall());
        List<Cinema> cinemasAll = cinemaService.findAll();

        model.addAttribute("cinemasAll",cinemasAll);

        return "hallform";
    }

    //update
    @GetMapping("hall/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){

        Hall hall = hallService.findById(id);
        List<Cinema> cinemasAll = cinemaService.findAll();

        model.addAttribute("hall", hall);
        model.addAttribute("cinemasAll",cinemasAll);

        return "update-hall";


    }


    @PostMapping("/hall")
    public String saveOrUpdate(@Valid @ModelAttribute Hall hall, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "hallerror";
        }
        Hall savedHall = hallService.save(hall);
        return "redirect:/hall/list";
    }

    @RequestMapping("/hall/delete/{id}")
    public String deleteById(@PathVariable String id){
        hallService.deleteById(Long.valueOf(id));
        return "redirect:/hall/list";
    }
}
