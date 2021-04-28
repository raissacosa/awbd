package com.example.demo.service;

import com.example.demo.domain.Cinema;
import com.example.demo.domain.Descripton;
import com.example.demo.domain.Genre;
import com.example.demo.domain.Movie;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{


    private final Logger log = LoggerFactory.getLogger(GenreServiceImpl.class);

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll(){
        return null;
    }
    @Override
    public Movie findById(Long l){
        Optional<Movie> movieOptional = movieRepository.findById(l);
        if (!movieOptional.isPresent()){
            throw new ResourceNotFoundException("movie " + l + " not found");
        }
        return movieOptional.get();
    }
    @Override
    public Movie save(Movie movie){
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie;
    }
    @Override
    public void deleteById(Long id){
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {
            throw new RuntimeException("Filmul nu a fost gasit!");
        }
        log.info("Delete by id ", id);
        movieRepository.deleteById(id);
    }

    @Override
    public Page<Movie> findPaginatedMovies(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return movieRepository.findAll(pageable);
    }

    @Override
    public List<Movie> findByMovieName(String movieName){
        return movieRepository.findByMovieName(movieName);
    }

    @Override
    public void saveDescription(Long movieId, String descriptionText){
        try {
            Movie movie = movieRepository.findById(movieId).get();
            Descripton descripton = movie.getDescripton();

            if (descripton == null){
                descripton = new Descripton();
            }

            descripton.setDescription(descriptionText);
            movie.setDescripton(descripton);
            descripton.setMovie(movie);
            movieRepository.save(movie);

        }
        catch (Exception e){

        }
    }

}
