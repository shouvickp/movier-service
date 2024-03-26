package dev.shouvick.movier.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.shouvick.movier.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
	Optional<Movie> findByImdbId(String imdbId);
}
