package com.services.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("user_rating")
public class Rating {
    @Id
    private String ratingUuid;
    private String userUuid;
    private String hotelUuid;
    private Long rating;
    private String feedback;
}
