package com.mmarciniak.reservationservice.entity;

import com.mmarciniak.reservationservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDtoBuilder {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDtoBuilder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public  UserDto userToUserDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        userDto.setRole(user.getRole());

        return userDto;
    }
}
