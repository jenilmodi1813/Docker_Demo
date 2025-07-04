package com.services.services;

import com.services.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    Rating getRating(String uuid);

    List<Rating> getAll();

    List<Rating> getByUserId(String uuid);

    List<Rating> getByHotelId(String uuid);

}
