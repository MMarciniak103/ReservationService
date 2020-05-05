package com.mmarciniak.reservationservice.dtobuilder;

import com.mmarciniak.reservationservice.entity.UserDto;
import com.mmarciniak.reservationservice.model.UserPojo;
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

    public UserDto userToUserDto(UserPojo userPojo)
    {
        UserDto userDto = new UserDto();
        userDto.setName(userPojo.getName());
        userDto.setPasswordHash(passwordEncoder.encode(userPojo.getPassword()));
        userDto.setRole(userPojo.getRole());

        return userDto;
    }
}
