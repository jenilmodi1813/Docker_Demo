package com.services.repositories;

import com.services.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

    List<Rating> findByUserUuid(String uuid);
    List<Rating> findByHotelUuid(String uuid);

}
