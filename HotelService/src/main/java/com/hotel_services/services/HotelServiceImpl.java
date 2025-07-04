package com.hotel_services.services;

import com.hotel_services.entities.Hotel;
import com.hotel_services.entities.Rating;
import com.hotel_services.exception.ResourceNotFoundException;
import com.hotel_services.repositories.HotelRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {

        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(UUID uuid) {
        Hotel hotel = hotelRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Hotel with given Id Not Found : "));

//        RestClient restClient = RestClient.create();
//        List<Rating> ratingList = restClient.get()
//                .uri("http://localhost:8083/Rating/getByHotelId/Hotel/" + uuid)
//                .retrieve()
//                .body(new ParameterizedTypeReference<List<Rating>>() {});
//        hotel.setRatings(ratingList);

        List<Rating> ratingList= WebClient.create()
                .get()
                .uri("http://localhost:8083/Rating/getByHotelId/Hotel/" + uuid)
                .retrieve()
                .bodyToFlux(Rating.class)
                .collectList()
                .block();
        hotel.setRatings(ratingList);
        return hotel;
    }
}
