package com.mmarciniak.reservationservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(path = "/registration",method = RequestMethod.GET)
    public String registrationForm(){
        return "registrationForm";
    }

}
