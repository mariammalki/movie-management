package com.example.movie_management.Service;

import com.example.movie_management.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private List<Movie> movies = new ArrayList<>();
    private Long currentId = 1L;

    public Movie createMovie(Movie movie) {
        movie.setId(currentId++);
        movies.add(movie);
        return movie;
    }

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Optional<Movie> getMovieById(Long id) {
        return movies.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> existingMovie = getMovieById(id);
        if (existingMovie.isPresent()) {
            Movie movie = existingMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setDirector(updatedMovie.getDirector());
            movie.setGenre(updatedMovie.getGenre());
            return movie;
        }
        return null; // ou tu peux lancer une exception
    }

    public void deleteMovie(Long id) {
        movies.removeIf(m -> m.getId().equals(id));
    }
}
