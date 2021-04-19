package com.example.demo.controller;

import com.example.demo.domain.Cinema;
import com.example.demo.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CinemaService cinemaService;

    @GetMapping("/showLogInForm")
    public String showLogInForm(){ return "login"; }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("errorMessage","Invalid user or password");
        return "login-error";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }

    @RequestMapping({"", "/", "/index"})
    public ModelAndView cinemasList(){
        ModelAndView modelAndView = new ModelAndView("cinemas");
        List<Cinema> cinemas = cinemaService.findAll();
        modelAndView.addObject("cinemas",cinemas);
        return modelAndView;
    }

}
