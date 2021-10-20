package com.example.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.movies.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}