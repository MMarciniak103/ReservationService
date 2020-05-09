package com.mmarciniak.reservationservice.controller;

import com.google.gson.Gson;
import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminPanelController {

    private DoctorService doctorService;

    @Autowired
    public AdminPanelController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping(value = "/adminPage",method = RequestMethod.GET)
    public String loadAdminPage(){
        return "adminPanel";
    }


    @RequestMapping(value = "/addDoctor",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDoctor(@RequestBody Doctor doctor){


        if(doctor.getInstitution() == null || doctor.getSpecialization() == null){
            Map<String, String> result = new HashMap<>();
            Gson gson = new Gson();
            String status;
            result.put("message","Doctor must have specialization and institution");
            status = gson.toJson(result);
            return new ResponseEntity(status, HttpStatus.BAD_REQUEST);
        }

        doctorService.saveDoctor(doctor);

        return ResponseEntity.status(HttpStatus.OK).body(doctor);
    }
}
