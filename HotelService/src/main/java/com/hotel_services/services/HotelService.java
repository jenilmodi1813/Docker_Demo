package com.hotel_services.services;

import com.hotel_services.entities.Hotel;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotel(UUID uuid);
}
