package com.example.demo.service;

import com.example.demo.domain.Genre;
import com.example.demo.repositories.GenreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService{

    private final Logger log = LoggerFactory.getLogger(GenreServiceImpl.class);

    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll(){
        List<Genre> genres = new LinkedList<>();
        genreRepository.findAll().iterator().forEachRemaining(genres::add);
        log.info("Find all genres", genres);
        return genres;
    }

    @Override
    public Genre findById(Long l){
        Optional<Genre> genreOptional = genreRepository.findById(l);
        if (!genreOptional.isPresent()){
            throw new RuntimeException("Genul nu a fost gasit!");
        }
        log.info("Genre find by id ", genreOptional);
        return genreOptional.get();
    }

    @Override
    public Genre save(Genre genre){
        Genre savedGenre = genreRepository.save(genre);
        log.info("Saved genre ... ", savedGenre);
        return savedGenre;
    }

    @Override
    public Genre update(Genre genre){
        Optional<Genre> genreOptional = genreRepository.findById(genre.getId());

        if (!genreOptional.isPresent()) {
            throw new RuntimeException("Genre not found!");
        }


        Genre updatedGenre = genreRepository.save(genre);
        return updatedGenre;
    }


    @Override
    public void deleteById(Long id){

        Optional<Genre> genreOptional = genreRepository.findById(id);
        if (!genreOptional.isPresent()) {
            throw new RuntimeException("Genul nu a fost gasit!");
        }
        log.info("Delete by id ", id);
        genreRepository.deleteById(id);
    }

    @Override
    public Page<Genre> findPaginated(int pageNo, int pageSize){

        Pageable pageable = PageRequest.of(pageNo-1,pageSize);

        return genreRepository.findAll(pageable);


        /*
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Genre> list;

        List<Genre> genres = new LinkedList<>();
        genreRepository.findAll().iterator().forEachRemaining(genres::add);
        if (genres.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, genres.size());
            list = genres.subList(startItem, toIndex);
        }

        Page<Genre> genrePage = new PageImpl<Genre>(list, PageRequest.of(currentPage,pageSize), genres.size());

        return genrePage;*/

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
