package com.hotel_services.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private UUID ratingUuid;
    private UUID userUuid;
    private UUID hotelUuid;
    private Long rating;
    private String feedback;
    private Hotel hotel;
}
