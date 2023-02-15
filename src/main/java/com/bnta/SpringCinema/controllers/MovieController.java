package com.bnta.SpringCinema.controllers;

import com.bnta.SpringCinema.models.Movie;
import com.bnta.SpringCinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    //@Autowired
   // Movie movie;

    //GET /movies
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movie = movieService.getAllMovies();
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }


    //POST /movies
//    @PostMapping
//    public ResponseEntity<Movie> addMovie{
//        Movie movie = movieService.addMovie();
//        return new ResponseEntity<>(movie, HttpStatus.CREATED);
//    }

    //Add functionality to update a movie in the database
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie movieToBeSaved = movieService.creatMovie(movie);
        return new ResponseEntity<>(movieToBeSaved, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie movie){
        movie.setId(id);
        movieService.creatMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);

    }


    //Add functionality to delete a movie from the database
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //requestbody- deserialses json object and truns it into a ovie object
    //we can then take that movie and then craetes it

    //GET /movies/{id}
    @GetMapping(value = "/{id}")
        public ResponseEntity<Movie> getMovieById (@PathVariable int id){
            Movie movie = movieService.getMovieById(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }


    }