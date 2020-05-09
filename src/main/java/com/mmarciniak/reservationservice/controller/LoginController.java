package com.mmarciniak.reservationservice.controller;

import com.google.gson.Gson;
import com.mmarciniak.reservationservice.dtobuilder.UserDtoBuilder;
import com.mmarciniak.reservationservice.entity.UserDto;
import com.mmarciniak.reservationservice.model.UserPojo;
import com.mmarciniak.reservationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class LoginController {

    private UserService userService;
    private UserDtoBuilder userDtoBuilder;

    @Autowired
    public LoginController(UserService userService,UserDtoBuilder userDtoBuilder) {
        this.userService = userService;
        this.userDtoBuilder = userDtoBuilder;
    }

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(path = "/registration",method = RequestMethod.GET)
    public String registrationForm(){
        return "registrationForm";
    }


    @RequestMapping(path = "/registerUser",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerUser(@RequestBody UserPojo userPojo){
        Map<String, String> result = new HashMap<>();
        Gson gson = new Gson();
        String status;

        if(userPojo.getName().isEmpty() || userPojo.getPassword().isEmpty()){
            result.put("message","You must provide username and password!");
            status = gson.toJson(result);
            return new ResponseEntity(status, HttpStatus.BAD_REQUEST);
        }

        Optional<UserDto> userByName = userService.getUserByName(userPojo.getName());
        if(userByName.isPresent()){
            result.put("message",userPojo.getName()+" is already taken.");
            status = gson.toJson(result);
            return new ResponseEntity(status, HttpStatus.BAD_REQUEST);
        }

        userService.addNewUser(userDtoBuilder.userToUserDto(userPojo));

        result.put("message","Registration successful");
        status = gson.toJson(result);
        return new ResponseEntity(status,HttpStatus.OK);
    }
}
