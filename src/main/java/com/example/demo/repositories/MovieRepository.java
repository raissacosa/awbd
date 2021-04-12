package com.example.demo.repositories;

import com.example.demo.domain.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

}
