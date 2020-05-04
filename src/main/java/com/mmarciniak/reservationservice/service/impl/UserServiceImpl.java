package com.mmarciniak.reservationservice.service.impl;

import com.mmarciniak.reservationservice.entity.UserDto;
import com.mmarciniak.reservationservice.repository.UserRepository;
import com.mmarciniak.reservationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDto> getUserByName(String name) {
        return userRepository.findUserDtoByName(name);
    }

    @Override
    public UserDto addNewUser(UserDto userDto) {
        return userRepository.save(userDto);
    }
}
