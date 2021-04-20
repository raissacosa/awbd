package com.example.demo.service;

import com.example.demo.domain.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ActorService {
    List<Actor> findAll();
    Actor save(Actor actor);
    void deleteById(Long id);
    List<Actor> findBySurname(String surname);
}
