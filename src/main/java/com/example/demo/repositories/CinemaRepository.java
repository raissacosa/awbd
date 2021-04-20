package com.example.demo.repositories;

import com.example.demo.domain.Cinema;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CinemaRepository extends PagingAndSortingRepository<Cinema, Long> {
    @Query("select c from Cinema c where c.name = :name and c.city= :city")
    List<Cinema> findByCinemaNameAndCity(@Param("name") String cinemaName, @Param("city") String cinemaCity);
}
