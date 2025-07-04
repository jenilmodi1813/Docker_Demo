package com.services.services;

import com.services.entities.Hotel;
import com.services.entities.Rating;
import com.services.entities.Users;
import com.services.exceptions.ResourceNotFoundException;
import com.services.external.HotelService;
import com.services.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Users saveUser(Users user) {
//        UUID uuid = UUID.randomUUID();
//        user.setUuid(uuid);
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAll() {
        List<Users> usersList = userRepository.findAll();

        for(Users user: usersList){
            ArrayList<Rating> forObject =  restTemplate.getForObject("http://RATINGSERVICE/Rating/getByUserId/Users/"+user.getUserUid(), ArrayList.class);
            logger.info("{}",forObject);
            user.setRatings(forObject);
//            Hotel hotel = hotelService.getHotel();
        }

        return usersList;
    }

    @Override
    public Users getUser(UUID id) {
        Users users = userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given Id Not Found :("));
//        localhost:8083/Rating/getByUserId/Users/12f5520d-d583-444e-9b2f-84c309018c44
        Rating[] forObject =  restTemplate.getForObject("http://RATINGSERVICE/Rating/getByUserId/Users/"+users.getUserUid(), Rating[].class);
        logger.info("{}",forObject);
        List<Rating> list = Arrays.stream(forObject).toList();
        List<Rating> ratingList = list.stream().map(rating -> {
            //         localhost:8082/Hotel/getById/2ae7d39e-f8cd-4f3b-a584-d1ce900c4fee
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/Hotel/getById/" + rating.getHotelUuid(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelUuid());
//            logger.info("response status code :",forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        users.setRatings(ratingList);
        return users;
    }

}
