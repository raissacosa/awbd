package com.example.demo.repositories;

import com.example.demo.domain.Cinema;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CinemaRepository extends PagingAndSortingRepository<Cinema, Long> {

}
