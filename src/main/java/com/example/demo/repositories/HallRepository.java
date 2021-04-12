package com.example.demo.repositories;

import com.example.demo.domain.Hall;
import org.springframework.data.repository.CrudRepository;

public interface HallRepository extends CrudRepository<Hall, Long> {
}
