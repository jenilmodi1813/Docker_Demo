package com.hotel_services.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel  {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID hotelUuId;
    private String name;
    private String location;
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
