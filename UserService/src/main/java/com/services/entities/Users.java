package com.services.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userUid;
    private Date createdDate;
    private String name;
    private String email;
    private String password;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
