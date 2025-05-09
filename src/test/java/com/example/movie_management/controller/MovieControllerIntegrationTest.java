package com.example.movie_management.controller;

import com.example.movie_management.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class MovieControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private Movie movie;

    @BeforeEach
    public void setUp() {
        movie = new Movie();
        movie.setTitle("Inception");
        movie.setGenre("Sci-Fi");
        movie.setReleaseYear(2010);
    }

    @Test
    public void testGetMovieById() throws Exception {
        // Correction : passer l'ID sous forme de String
        mockMvc.perform(MockMvcRequestBuilders.get("/movies/{id}", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Inception"));
    }

    // Autres tests
}
