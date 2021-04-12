package com.example.demo.controller;

import com.example.demo.domain.Cinema;
import com.example.demo.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @RequestMapping("/cinema/list")
    public ModelAndView genresList(){
        ModelAndView modelAndView = new ModelAndView("cinemas");
        List<Cinema> cinemas = cinemaService.findAll();
        modelAndView.addObject("cinemas", cinemas);
        return modelAndView;
    }

    @GetMapping("/cinema/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("cinema",
                cinemaService.findById(Long.valueOf(id)));
        return "infocinema";
    }

    @RequestMapping("/cinema/delete/{id}")
    public String deleteById(@PathVariable String id){
        cinemaService.deleteById(Long.valueOf(id));
        return "redirect:/cinema/list";
    }
}
