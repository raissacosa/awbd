package com.example.demo.controller;

import com.example.demo.domain.Cinema;
import com.example.demo.service.CinemaService;
import com.example.demo.service.CinemaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    public String showById( @PathVariable String id, Model model){
        model.addAttribute("cinema",
                cinemaService.findById(Long.valueOf(id)));
        return "infocinema";
    }

    @RequestMapping("/cinema/delete/{id}")
    public String deleteById(@PathVariable String id){
        cinemaService.deleteById(Long.valueOf(id));
        return "redirect:/cinema/list";
    }

    @GetMapping("/cinema/findByNameAndCity")
    public ModelAndView findByCinemaNameAndCity(@RequestParam(value = "cinemaName", required = false) String cinemaName, @RequestParam(value = "cinemaCity", required = false) String cinemaCity){
        ModelAndView modelAndView = new ModelAndView("cinemas-name-city");
        List<Cinema> cinemas = cinemaService.findByCinemaNameAndCity(cinemaName,cinemaCity);
        modelAndView.addObject("cinemas", cinemas);
        return modelAndView;
    }
}
