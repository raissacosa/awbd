package com.example.demo.service;


import com.example.demo.domain.Cinema;
import com.example.demo.domain.Hall;

import java.util.List;

public interface HallService {
    List<Hall> findAll();
    Hall findById(Long l);
    Hall save(Hall hall);
    void deleteById(Long id);
}
