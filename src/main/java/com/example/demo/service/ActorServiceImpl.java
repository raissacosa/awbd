package com.example.demo.service;

import com.example.demo.domain.Actor;
import com.example.demo.domain.Genre;
import com.example.demo.repositories.ActorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    private final Logger log = LoggerFactory.getLogger(ActorServiceImpl.class);


    ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll(){
        List<Actor> actors = new LinkedList<>();
        actorRepository.findAll().iterator().forEachRemaining(actors::add);
        log.info("Find all actors", actors);
        return actors;
    }

    @Override
    public Actor save(Actor actor){
        Actor savedActor = actorRepository.save(actor);
        log.info("Saved actor ", savedActor);
        return savedActor;

    }

    @Override
    public void deleteById(Long id){
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (!actorOptional.isPresent()) {
            throw new RuntimeException("Actorul nu a fost gasit!");
        }
        log.info("Delete by id ", id);
        actorRepository.deleteById(id);
    }


}
