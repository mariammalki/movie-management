package com.example.movie_management;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    private final com.example.movie_management.MovieRepository repository;

    public MovieService(com.example.movie_management.MovieRepository repository) {
        this.repository = repository;
    }

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }
}


