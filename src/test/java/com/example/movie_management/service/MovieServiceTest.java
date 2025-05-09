package com.example.movie_management.service;

import com.example.movie_management.Movie;
import com.example.movie_management.repository.MovieRepository;
import com.example.movie_management.Service.MovieService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieServiceTest {

    private final MovieRepository movieRepository = mock(MovieRepository.class);
    private final MovieService movieService = new MovieService();

    @Test
    void testGetMovieById() {
        Movie movie = new Movie("Inception", "Christopher Nolan", 2010, "Sci-Fi");
        movie.setId(1L);

        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        Optional<Movie> result = movieService.getMovieById(1L);
        assertTrue(result.isPresent());
        assertEquals("Inception", result.get().getTitle());
    }
}
