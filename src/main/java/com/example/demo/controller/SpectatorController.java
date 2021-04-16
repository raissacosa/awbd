package com.example.demo.controller;


import com.example.demo.domain.Genre;
import com.example.demo.domain.Spectator;
import com.example.demo.service.SpectatorService;
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
public class SpectatorController {

    @Autowired
    SpectatorService spectatorService;

    public SpectatorController(SpectatorService spectatorService) {
        this.spectatorService = spectatorService;
    }

    @RequestMapping("/spectator/list")
    public ModelAndView spectatorsList(){
        ModelAndView modelAndView = new ModelAndView("spectators");
        List<Spectator> spectators = spectatorService.findAll();
        modelAndView.addObject("spectators", spectators);
        return modelAndView;
    }


    @RequestMapping("/spectator/new")
    public String newSpectator(Model model) {
        model.addAttribute("spectator", new Spectator());
        List<Spectator> spectatorsAll = spectatorService.findAll();

        model.addAttribute("spectatorsAll", spectatorsAll);

        return "spectatorform";
    }

    @PostMapping("/spectator")
    public String saveOrUpdate(@Valid @ModelAttribute Spectator spectator, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "spectatorform";
        }
        Spectator savedSpectator = spectatorService.save(spectator);
        return "redirect:/spectator/list";
    }

    @RequestMapping("/spectator/delete/{id}")
    public String deleteById(@PathVariable String id){
        spectatorService.deleteById(Long.valueOf(id));
        return "redirect:/spectator/list";
    }
}
