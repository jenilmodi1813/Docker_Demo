package com.services.services;

import com.services.entities.Rating;
import com.services.exception.ResourceNotFoundException;
import com.services.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        rating.setRatingUuid(UUID.randomUUID().toString());
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRating(String uuid) {
        return ratingRepository.findById(uuid).orElseThrow(()->new ResourceNotFoundException("Rating with given Id Not Found : "));
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getByUserId(String uuid) {
        return ratingRepository.findByUserUuid(uuid);
    }

    @Override
    public List<Rating> getByHotelId(String uuid) {
        return ratingRepository.findByHotelUuid(uuid);
    }
}
