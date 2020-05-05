package com.mmarciniak.reservationservice;

import com.mmarciniak.reservationservice.entity.UserDtoBuilder;
import com.mmarciniak.reservationservice.model.User;
import com.mmarciniak.reservationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OnStartHandler {

    private UserRepository userRepository;
    private UserDtoBuilder userDtoBuilder;

    @Autowired
    public OnStartHandler(UserRepository userRepository,UserDtoBuilder userDtoBuilder) {
        this.userRepository = userRepository;
        this.userDtoBuilder = userDtoBuilder;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill(){
        User user1 = new User("tom","123","ROLE_ADMIN");
        User user2 = new User("mark","123","ROLE_CUSTOMER");

        userRepository.save(userDtoBuilder.userToUserDto(user1));
        userRepository.save(userDtoBuilder.userToUserDto(user2));

    }
}
