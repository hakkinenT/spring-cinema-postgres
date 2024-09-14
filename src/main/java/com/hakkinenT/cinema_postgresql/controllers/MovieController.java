package com.hakkinenT.cinema_postgresql.controllers;

import com.hakkinenT.cinema_postgresql.dto.MovieDTO;
import com.hakkinenT.cinema_postgresql.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable Integer id){
        MovieDTO movie = movieService.findMovieById(id);
        return ResponseEntity.ok(movie);
    }
}
