package com.services.controller;
import com.services.entities.Users;
import com.services.services.UserService;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@Tag(name = "UserController")
@RequestMapping("/Users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<Users> createUser(
            @RequestBody Users user
    ){
        Users user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Users> getById(
            @PathVariable UUID id
    ){
        Users user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Users>> getAll(){
        List<Users> all = userService.getAll();
        return ResponseEntity.ok(all);
    }

}
