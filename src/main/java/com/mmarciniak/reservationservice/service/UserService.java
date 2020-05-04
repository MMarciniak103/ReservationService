package com.mmarciniak.reservationservice.service;

import com.mmarciniak.reservationservice.entity.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<UserDto> getUserByName(String name);
    UserDto addNewUser(UserDto userDto);
}
