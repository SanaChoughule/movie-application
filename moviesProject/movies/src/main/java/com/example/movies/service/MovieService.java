package com.example.movies.service;

import java.util.List;

import com.example.movies.entity.Movie;

public interface MovieService {
	List<Movie> getAllMovies();

	void saveMovie(Movie movie);

	Movie getMovieById(long id);

	void deleteMovieById(long id);
}