package com.example.demo.repositories;

import com.example.demo.domain.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
