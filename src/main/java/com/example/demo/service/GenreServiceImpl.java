package com.example.demo.service;

import com.example.demo.domain.Genre;
import com.example.demo.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{

    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll(){
        List<Genre> genres = new LinkedList<>();
        genreRepository.findAll().iterator().forEachRemaining(genres::add);
        return genres;
    }

    @Override
    public Genre findById(Long l){
        Optional<Genre> genreOptional = genreRepository.findById(l);
        if (!genreOptional.isPresent()){
            throw new RuntimeException("Genul nu a fost gasit!");
        }

        return genreOptional.get();
    }

    @Override
    public Genre save(Genre genre){
        Genre savedGenre = genreRepository.save(genre);
        return savedGenre;
    }

    @Override
    public void deleteById(Long id){

        Optional<Genre> genreOptional = genreRepository.findById(id);
        if (!genreOptional.isPresent()) {
            throw new RuntimeException("Genul nu a fost gasit!");
        }

        genreRepository.deleteById(id);
    }

    /*
    Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new RuntimeException("Product not found!");
        }
        Product product = productOptional.get();
        List<Category> categories = new LinkedList<Category>();
        product.getCategories().iterator().forEachRemaining(categories::add);

        for (Category category: categories
                ) {
            product.removeCategory(category);
        }

        productRepository.save(product);
        productRepository.deleteById(id);
    * */
}
