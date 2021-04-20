package com.example.demo.repositories;

import com.example.demo.domain.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query("select c from Actor c where c.surname = :surname")
    List<Actor> findBySurame(@Param(value = "surname") String surname);
}
