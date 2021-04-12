package com.example.demo.service;

import com.example.demo.domain.Hall;
import com.example.demo.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class HallServiceImpl implements HallService{

    HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public List<Hall> findAll(){
        List<Hall> halls = new LinkedList<>();
        hallRepository.findAll().iterator().forEachRemaining(halls::add);
        return halls;
    }



    @Override
    public Hall save(Hall hall){
        Hall savedHall = hallRepository.save(hall);
        return savedHall;
    }
    public void deleteById(Long id){

    }
}
