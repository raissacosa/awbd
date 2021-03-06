package com.example.demo.service;

import com.example.demo.domain.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenreService {
    List<Genre> findAll();
    Genre findById(Long l);
    Genre save(Genre genre);
    Genre update(Genre genre);
    void deleteById(Long id);
    Page<Genre> findPaginated(int page, int size);
}
