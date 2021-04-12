package com.example.demo.service;

import com.example.demo.domain.Cinema;

import java.util.List;

public interface CinemaService {
    List<Cinema> findAll();
    Cinema findById(Long l);
    void deleteById(Long id);
}
