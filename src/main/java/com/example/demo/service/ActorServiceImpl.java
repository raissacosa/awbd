package com.example.demo.service;

import com.example.demo.domain.Actor;
import com.example.demo.domain.Genre;
import com.example.demo.repositories.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll(){
        List<Actor> actors = new LinkedList<>();
        actorRepository.findAll().iterator().forEachRemaining(actors::add);
        return actors;
    }

    @Override
    public Actor save(Actor actor){
        Actor savedActor = actorRepository.save(actor);
        return savedActor;

    }

    @Override
    public void deleteById(Long id){
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (!actorOptional.isPresent()) {
            throw new RuntimeException("Actorul nu a fost gasit!");
        }

        actorRepository.deleteById(id);
    }


}
