package com.example.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.movies.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}