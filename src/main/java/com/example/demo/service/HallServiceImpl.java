package com.example.demo.service;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Hall;
import com.example.demo.repositories.HallRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class HallServiceImpl implements HallService{

    private final Logger log = LoggerFactory.getLogger(HallServiceImpl.class);

    HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Hall> findAll(){
        List<Hall> halls = new LinkedList<>();
        hallRepository.findAll().iterator().forEachRemaining(halls::add);

        log.info("Find all halls", halls);
        return halls;
    }



    @Override
    public Hall save(Hall hall){
        Hall savedHall = hallRepository.save(hall);
        log.info("Saved hall ", savedHall);
        return savedHall;
    }

    @Override
    public void deleteById(Long id){
        Optional<Hall> hallOptional = hallRepository.findById(id);
        if (!hallOptional.isPresent()) {
            throw new RuntimeException("Sala nu a fost gasit!");
        }
        log.info("Delete by id ", id);
        hallRepository.deleteById(id);
    }
}
