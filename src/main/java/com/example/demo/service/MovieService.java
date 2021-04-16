package com.example.demo.service;

import com.example.demo.domain.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    Movie findById(Long l);
    Movie save(Movie movie);
    void deleteById(Long id);

}
