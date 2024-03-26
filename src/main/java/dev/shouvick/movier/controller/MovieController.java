package dev.shouvick.movier.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.shouvick.movier.model.Movie;
import dev.shouvick.movier.service.MovieService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor
public class MovieController {
	
	private final MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> movies() {
		return ResponseEntity.ok().body(movieService.findAllMovies());
	}
	
	@GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return ResponseEntity.ok().body(movieService.findMovieByImdbId(imdbId));
    }

}
