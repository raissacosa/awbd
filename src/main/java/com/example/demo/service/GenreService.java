package com.example.demo.service;

import com.example.demo.domain.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();
    Genre findById(Long l);
    Genre save(Genre genre);
    void deleteById(Long id);
}
