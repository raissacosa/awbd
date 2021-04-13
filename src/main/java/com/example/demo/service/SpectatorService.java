package com.example.demo.service;

import com.example.demo.domain.Spectator;

import java.util.List;

public interface SpectatorService {
    List<Spectator> findAll();
    Spectator save(Spectator spectator);
    void deleteById(Long id);


}
