package com.example.demo.service;

import com.example.demo.domain.Cinema;
import com.example.demo.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CinemaService {



    List<Cinema> findAll();
    Cinema findById(Long l);
    void deleteById(Long id);

    List<Cinema> findByCinemaNameAndCity(String cinemaName,String cinemaCity);
}
