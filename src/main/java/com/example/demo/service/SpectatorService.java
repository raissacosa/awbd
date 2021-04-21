package com.example.demo.service;

import com.example.demo.domain.Hall;
import com.example.demo.domain.Spectator;

import java.util.List;

public interface SpectatorService {
    List<Spectator> findAll();
    Spectator findById(Long l);
    Spectator save(Spectator spectator);
    void deleteById(Long id);


}
