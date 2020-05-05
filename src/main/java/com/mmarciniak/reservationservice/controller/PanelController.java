package com.mmarciniak.reservationservice.controller;

import com.mmarciniak.reservationservice.entity.Appointment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PanelController {

    @RequestMapping("/")
    public String loadMainPage(){
        return "webpage";
    }


    @RequestMapping(value = "/makeAppointment",method = RequestMethod.POST)
    public String makeAppointment(@RequestBody Appointment appointment){


        return null;
    }



}
