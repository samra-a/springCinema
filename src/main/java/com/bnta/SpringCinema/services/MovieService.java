package com.bnta.SpringCinema.services;

import com.bnta.SpringCinema.models.Movie;
import com.bnta.SpringCinema.repositories.IMovies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    IMovies movieRepository;

    private ArrayList<Movie> cinema;

    public MovieService(IMovies movieRepository, ArrayList<Movie> movies) {
        this.movieRepository = movieRepository;
        this.cinema = movies;
    }

    public MovieService() {
        this.cinema = new ArrayList<>();
    }

    public Movie creatMovie(Movie newMovie){
        return movieRepository.save(newMovie);
    }

    public void deleteMovie(Movie oldMovie){
        this.movieRepository.delete(oldMovie);
    }

//    public void addMovie(Movie movie){
//        this.cinema.add(movie);
//    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id){
        return movieRepository.findById(id).get();
    }

    public IMovies getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(IMovies movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ArrayList<Movie> getMovies() {
        return cinema;
    }

    public void setMovies(ArrayList<Movie> cinema) {
        this.cinema = cinema;
    }
}
