package com.example.demo.service;

import com.example.demo.domain.Movie;
import com.example.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll(){
        return null;
    }
    @Override
    public Movie findById(Long l){
        return null;
    }
    @Override
    public Movie save(Movie movie){
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }
    @Override
    public void deleteById(Long id){

    }
}
