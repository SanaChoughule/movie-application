package com.example.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.movies.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
