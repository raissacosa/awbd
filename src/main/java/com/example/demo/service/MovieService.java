package com.example.demo.service;

import com.example.demo.domain.Genre;
import com.example.demo.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    Movie findById(Long l);
    Movie save(Movie movie);
    void deleteById(Long id);
    Page<Movie> findPaginatedMovies(int page, int size);
    List<Movie> findByMovieName(String movieName);
    void saveDescription(Long movieId, String descriptionText);

}
