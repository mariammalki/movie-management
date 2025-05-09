package com.example.movie_management.service;

import com.example.movie_management.Movie;
import com.example.movie_management.Service.MovieService;
import com.example.movie_management.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    private Movie movie;

    @BeforeEach
    public void setUp() {
        movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");
        movie.setReleaseYear(2010);
    }

    @Test
    public void testCreateMovie() {
        when(movieRepository.save(movie)).thenReturn(movie);

        // Passer un ID en tant que String si c'est requis dans la méthode
        Movie createdMovie = movieService.createMovie(movie);
        assertEquals("Inception", createdMovie.getTitle());
    }

    // Autres tests
}
