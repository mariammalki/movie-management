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
        System.out.println("Saving movie: " + movie);
        Movie savedMovie = repository.save(movie);
        System.out.println("Saved movie: " + savedMovie);
        return savedMovie;
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }
}
