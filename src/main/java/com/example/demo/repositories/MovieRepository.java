package com.example.demo.repositories;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("select m from Movie m where m.name = :name")
    List<Movie> findByMovieName(@Param("name") String movieName);
}
