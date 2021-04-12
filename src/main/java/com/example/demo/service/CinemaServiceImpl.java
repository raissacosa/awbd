package com.example.demo.service;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Genre;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService{

    CinemaRepository cinemaRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<Cinema> findAll(){
        List<Cinema> cinemas = new LinkedList<>();
        cinemaRepository.findAll().iterator().forEachRemaining(cinemas::add);
        return cinemas;
    }

    @Override
    public Cinema findById(Long l){
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(l);
        if(!cinemaOptional.isPresent()) {
            throw new ResourceNotFoundException("cinema " + l + " not found");
        }
        return cinemaOptional.get();
    }

    @Override
    public void deleteById(Long id){
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(id);
        if (!cinemaOptional.isPresent()) {
            throw new RuntimeException("Cinemaul nu a fost gasit!");
        }

        cinemaRepository.deleteById(id);
    }
}
