package com.example.demo.controller;

import com.example.demo.domain.Actor;
import com.example.demo.domain.Genre;
import com.example.demo.domain.Spectator;
import com.example.demo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping("/actor/list")
    public ModelAndView actorsList(){
        ModelAndView modelAndView = new ModelAndView("actors");
        List<Actor> actors = actorService.findAll();
        modelAndView.addObject("actors",actors);
        return modelAndView;
    }

    @RequestMapping("/actor/new")
    public String newActor(Model model) {
        model.addAttribute("actor", new Actor());
        List<Actor> actorsAll = actorService.findAll();

        model.addAttribute("actorsAll", actorsAll);

        return "actorform";
    }

    @GetMapping("actor/update/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){

        Actor actor = actorService.findById(id);

        model.addAttribute("actor", actor);

        return "update-actor";


    }


    @PostMapping("/actor")
    public String saveOrUpdate(@Valid @ModelAttribute Actor actor, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "actorform";
        }

        Actor savedActor = actorService.save(actor);
        return "redirect:/actor/list";
    }

    @RequestMapping("/actor/delete/{id}")
    public String deleteById(@PathVariable String id){
        actorService.deleteById(Long.valueOf(id));
        return "redirect:/actor/list";
    }

    @GetMapping("/actor/findByLastName")
    public ModelAndView findBySurname(@RequestParam(value = "surname") String surname){
        ModelAndView modelAndView = new ModelAndView("actors-byLastName");
        List<Actor> actors = actorService.findBySurname(surname);
        modelAndView.addObject("actors",actors);
        return modelAndView;

    }

}
