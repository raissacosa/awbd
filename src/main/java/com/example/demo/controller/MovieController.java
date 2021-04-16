package com.example.demo.controller;

import com.example.demo.domain.Actor;
import com.example.demo.domain.Genre;
import com.example.demo.domain.Movie;
import com.example.demo.service.ActorService;
import com.example.demo.service.GenreService;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    GenreService genreService;

    @Autowired
    ActorService actorService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/movie/new")
    public String newMovie(Model model){
        model.addAttribute("movie", new Movie());

        List<Genre> genresAll = genreService.findAll();
        model.addAttribute("genresAll", genresAll);

        List<Actor> actorsAll = actorService.findAll();
        model.addAttribute("actorsAll", actorsAll);

        return "movieform";
    }

    @PostMapping("/movie")
    public String saveOrUpdate(@ModelAttribute Movie movie){
        Movie savedMovie = movieService.save(movie);
        return "redirect:/movie/new";
    }

}
