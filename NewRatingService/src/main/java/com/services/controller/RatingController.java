package com.services.controller;

import com.services.entities.Rating;
import com.services.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/addRating")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){

        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getAll(){
        return ResponseEntity.ok(ratingService.getAll());
    }

    @GetMapping("getRating/{uuid}")
    public ResponseEntity<Rating> getRating(@PathVariable String uuid){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRating(uuid));
    }

    @GetMapping("getByUserId/Users/{uuid}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String uuid){
        return ResponseEntity.ok(ratingService.getByUserId(uuid));
    }

    @GetMapping("getByHotelId/Hotel/{uuid}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String uuid){
        return ResponseEntity.ok(ratingService.getByHotelId(uuid));
    }
}
