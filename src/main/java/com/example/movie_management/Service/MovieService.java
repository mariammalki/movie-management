package com.example.movie_management;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final com.example.movie_management.MovieRepository repository;

    public MovieService(com.example.movie_management.MovieRepository repository) {
        this.repository = repository;
    }

    @CacheEvict(value = "movies", allEntries = true)
    public Movie saveMovie(Movie movie) {
        System.out.println("Saving movie: " + movie);
        Movie savedMovie = repository.save(movie);
        System.out.println("Saved movie: " + savedMovie);
        return savedMovie;
    }

    @Cacheable("movies")
    public List<Movie> getAllMovies() {
        System.out.println("Fetching all movies from database...");
        return repository.findAll();
    }
}
