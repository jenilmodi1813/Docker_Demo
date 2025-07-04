package com.services.external;//package com.hotel_services.external.services;

import com.services.entities.Hotel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {
    @GetMapping("/Hotel/getById/{id}")
    Hotel getHotel(@PathVariable("id") UUID uuid);
}
