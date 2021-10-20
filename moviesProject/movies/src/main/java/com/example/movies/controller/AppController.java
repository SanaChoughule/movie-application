package com.example.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.movies.entity.Actor;
import com.example.movies.entity.Director;
import com.example.movies.entity.Movie;
import com.example.movies.service.MovieService;

@Controller
public class AppController {
	
	 @Autowired
	    private MovieService movieService;

	    // display list of movies
	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        model.addAttribute("listMovies", movieService.getAllMovies());
	        return "index";
	    }

	    @GetMapping("/showNewMovieForm")
	    public String showNewMovieForm(Model model) {
	        
	    	// create model attribute to bind form data
	        Movie movie = new Movie();
	        Actor actor = new Actor();
	        Director director = new Director();
	        
	        // connection of movie - actor 
	        movie.setActor(actor);
	        actor.setMovie(movie);

	        // connection of movie - director
	        movie.setDirector(director);
	        director.setMovie(movie);
	        
	        model.addAttribute("movie", movie);
	        
	        return "new_movie";
	    }

	    @PostMapping("/saveMovie")
	    public String saveEmployee(@ModelAttribute("movie") Movie movie) {
	        
	    	// save movie to database
	        movieService.saveMovie(movie);
	        return "redirect:/";
	    }

	    @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get movie from the service
	        Movie movie = movieService.getMovieById(id);

	        // set movie as a model attribute to pre-populate the form
	        model.addAttribute("movie", movie);
	        return "update_movie";
	    }

	    @GetMapping("/deleteMovie/{id}")
	    public String deleteMovie(@PathVariable(value = "id") long id) {

	        // call delete employee method 
	        this.movieService.deleteMovieById(id);
	        return "redirect:/";
	    }

}
