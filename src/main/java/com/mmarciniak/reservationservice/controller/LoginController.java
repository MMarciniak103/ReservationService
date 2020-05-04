package com.mmarciniak.reservationservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    /**
     * Method that handles user authentication
     * @return login page view.
     */
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String showLoginPage(){
        System.out.println("YOOOO");
        return "login-page";
    }

}
