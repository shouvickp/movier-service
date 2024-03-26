package dev.shouvick.movier.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.shouvick.movier.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}
