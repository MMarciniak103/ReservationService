package com.mmarciniak.reservationservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PanelController {

    @RequestMapping("/")
    public String loadMainPage(){
        return "webpage";
    }
}
