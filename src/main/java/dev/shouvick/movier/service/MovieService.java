package dev.shouvick.movier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.shouvick.movier.model.Movie;
import dev.shouvick.movier.repository.MovieRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }

	public Optional<Movie> findMovieByImdbId(String imdbId) {
		Optional<Movie> movieOpt = repository.findByImdbId(imdbId);
		return movieOpt;
	}
}
