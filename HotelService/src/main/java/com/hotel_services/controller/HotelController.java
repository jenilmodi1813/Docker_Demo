package com.hotel_services.controller;

import com.hotel_services.entities.Hotel;
import com.hotel_services.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/addHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Hotel> createHotel(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> createHotel(){
        return ResponseEntity.ok(hotelService.getAll());
    }

}
