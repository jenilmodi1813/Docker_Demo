package com.services.services;

import com.services.entities.Users;

import java.util.List;
import java.util.UUID;

public interface UserService {

    Users saveUser(Users user);

    List<Users> getAll();

    Users getUser(UUID id);
}
