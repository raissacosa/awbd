package com.example.demo.service;

import com.example.demo.domain.Genre;
import com.example.demo.domain.Spectator;
import com.example.demo.repositories.SpectatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class SpectatorServiceImpl implements SpectatorService{

    private final Logger log = LoggerFactory.getLogger(SpectatorServiceImpl.class);

    SpectatorRepository spectatorRepository;

    @Autowired
    public SpectatorServiceImpl(SpectatorRepository spectatorRepository) {
        this.spectatorRepository = spectatorRepository;
    }

    @Override
    public List<Spectator> findAll(){
        List<Spectator> spectators = new LinkedList<>();
        spectatorRepository.findAll().iterator().forEachRemaining(spectators::add);
        log.info("Find all spectators", spectators);
        return spectators;
    }

    @Override
    public Spectator save(Spectator spectator){
        Spectator savedSpectator = spectatorRepository.save(spectator);
        return savedSpectator;
    }
    public void deleteById(Long id){
        Optional<Spectator> spectatorOptional = spectatorRepository.findById(id);
        if (!spectatorOptional.isPresent()) {
            throw new RuntimeException("Spectatorul nu a fost gasit!");
        }

        log.info("Delete by id ", id);
        spectatorRepository.deleteById(id);
    }
}
