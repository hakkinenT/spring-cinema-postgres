package com.hakkinenT.cinema_postgresql.repositories;

import com.hakkinenT.cinema_postgresql.entities.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryTests {
    @Autowired
    private MovieRepository movieRepository;

    private Integer existingMovieId;
    private LocalDateTime exhibitionDate;

    @BeforeEach
    void setUp() throws Exception{
        existingMovieId = 1;
        exhibitionDate = LocalDateTime.of(2024, 4,6, 9, 0, 0);
    }


    @Test
    public void searchMovieByIdShouldReturnMovieAndSessionInformation(){
        List<Movie> movies = movieRepository.searchMovieById(existingMovieId);
        Assertions.assertFalse(movies.isEmpty());
        Assertions.assertEquals(1, movies.getFirst().getId());
        Assertions.assertEquals("TITANIC", movies.getFirst().getTitle());
        Assertions.assertEquals("12", movies.getFirst().getAgeRating());
        Assertions.assertEquals(exhibitionDate.toLocalDate(), movies.getFirst().getSessions().getFirst().getExhibitionDate().toLocalDate());
        Assertions.assertEquals(exhibitionDate.toLocalTime(), movies.getFirst().getSessions().getFirst().getExhibitionDate().toLocalTime());

    }
}
