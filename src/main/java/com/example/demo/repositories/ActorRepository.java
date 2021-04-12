package com.example.demo.repositories;

import com.example.demo.domain.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
}
