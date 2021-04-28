package com.example.demo.controller;

import com.example.demo.domain.*;
import com.example.demo.service.ActorService;
import com.example.demo.service.GenreService;
import com.example.demo.service.MovieService;
import com.example.demo.service.SpectatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    GenreService genreService;

    @Autowired
    ActorService actorService;

    @Autowired
    SpectatorService spectatorService;

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

        List<Spectator> spectatorsAll = spectatorService.findAll();
        model.addAttribute("spectatorsAll", spectatorsAll);

        return "movieform";
    }

    @PostMapping("/movie")
    public String saveOrUpdate(@ModelAttribute Movie movie){
        Movie savedMovie = movieService.save(movie);

        //movieService.saveDescription(savedMovie.getId(),description);

        return "redirect:/movies";
    }


    @GetMapping("/movies")
    public String viewMovie(Model model){
        return findPaginatedMovies(1,model);
    }

    @GetMapping("/pages/{pageNo}")
    public String findPaginatedMovies(@PathVariable(value = "pageNo") int pageNo, Model model){

        int pageSize = 5;
        Page<Movie> page = movieService.findPaginatedMovies(pageNo,pageSize);
        List<Movie> listMovies = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listMovies", listMovies);

        return "listMovies";

    }

    @RequestMapping("/movie/delete/{id}")
    public String deleteById(@PathVariable String id){
        movieService.deleteById(Long.valueOf(id));
        return "redirect:/movies";
    }

    @GetMapping("/movie/findByName")
    public ModelAndView findByMovieName(@RequestParam(value = "movieName", required = false) String movieName){
        ModelAndView modelAndView = new ModelAndView("movies-name");
        List<Movie> movies = movieService.findByMovieName(movieName);
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }

    @GetMapping("/movie/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("movie", movieService.findById(Long.valueOf(id)));
        return "infomovie";
    }


}
