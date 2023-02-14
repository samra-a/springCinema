package com.bnta.SpringCinema.repositories;

import com.bnta.SpringCinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovies extends JpaRepository<Movie, Integer> {

}
