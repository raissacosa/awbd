package com.example.demo.service;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Genre;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.CinemaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService{

    private final Logger log = LoggerFactory.getLogger(CinemaServiceImpl.class);

    CinemaRepository cinemaRepository;

    @Autowired
    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<Cinema> findAll(){
        List<Cinema> cinemas = new LinkedList<>();
        cinemaRepository.findAll().iterator().forEachRemaining(cinemas::add);
        log.info("Find all cinemas", cinemas);
        return cinemas;
    }

    @Override
    public Cinema findById(Long l){
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(l);
        if(!cinemaOptional.isPresent()) {
            throw new ResourceNotFoundException("cinema " + l + " not found");
        }
        log.info("Cinema find by id ...", cinemaOptional);
        return cinemaOptional.get();
    }

    @Override
    public void deleteById(Long id){
        Optional<Cinema> cinemaOptional = cinemaRepository.findById(id);
        if (!cinemaOptional.isPresent()) {
            throw new RuntimeException("Cinemaul nu a fost gasit!");
        }
        log.info("Delete by id ", id);
        cinemaRepository.deleteById(id);
    }

    @Override
    public List<Cinema> findByCinemaNameAndCity(String cinemaName,String cinemaCity){
        return cinemaRepository.findByCinemaNameAndCity(cinemaName,cinemaCity);
    }

    @Override
    public void save(Cinema cinema){
        cinemaRepository.save(cinema);
    }
}
