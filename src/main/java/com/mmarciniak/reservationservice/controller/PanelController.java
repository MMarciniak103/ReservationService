package com.mmarciniak.reservationservice.controller;

import com.google.gson.Gson;
import com.mmarciniak.reservationservice.dtobuilder.AppointmentDtoBuilder;
import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.entity.UserDto;
import com.mmarciniak.reservationservice.exceptions.AppointmentDateInvalid;
import com.mmarciniak.reservationservice.exceptions.InvalidDoctorInfo;
import com.mmarciniak.reservationservice.model.AppointmentPojo;
import com.mmarciniak.reservationservice.service.AppointmentService;
import com.mmarciniak.reservationservice.service.DoctorService;
import com.mmarciniak.reservationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PanelController {

    private UserService userService;
    private DoctorService doctorService;
    private AppointmentService appointmentService;
    private AppointmentDtoBuilder appointmentDtoBuilder;

    @Autowired
    public PanelController(UserService userService, DoctorService doctorService, AppointmentService appointmentService, AppointmentDtoBuilder appointmentDtoBuilder) {
        this.userService = userService;
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
        this.appointmentDtoBuilder = appointmentDtoBuilder;
    }

    @RequestMapping("/")
    public String loadMainPage(Model model,HttpServletRequest httpServletRequest) {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors", doctors);

//
//        String userName = httpServletRequest.getUserPrincipal().getName();
//        UserDto user = userService.getUserByName(userName).get();
//
//        List<AppointmentDto> userAppointments = getUserAppointments(user);
//        model.addAttribute("userAppointments",userAppointments);

        return "webpage";
    }

    private List<AppointmentDto> getUserAppointments(UserDto user){

        List<AppointmentDto> userAppointments = appointmentService.findUserAppointments(user);
        return userAppointments;
    }


    @RequestMapping(value = "/getAppointments/{userName}",method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentDto> getAppointments(@PathVariable String userName){
        UserDto user = userService.getUserByName(userName).get();
        List<AppointmentDto> userAppointments = getUserAppointments(user);

        return userAppointments;
    }


    @RequestMapping(value = "/cancelAppointment/{id}",method = RequestMethod.DELETE)
    public ResponseEntity cancelAppointment(@PathVariable Long id){
            appointmentService.deleteAppointmentById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(value = "/makeAppointment", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity makeAppointment(@RequestBody AppointmentPojo appointment, HttpServletRequest httpServletRequest) {

        String userName = httpServletRequest.getUserPrincipal().getName();

        UserDto user = userService.getUserByName(userName).get();

        Map<String, String> result = new HashMap<>();
        Gson gson = new Gson();
        String status;

        if(appointment.getTime() == null || appointment.getDate() == null){
            result.put("message","You must provide date and time");
            status = gson.toJson(result);
            return new ResponseEntity(status,HttpStatus.BAD_REQUEST);
        }


        try {
            AppointmentDto appointmentDto = validateAppointment(appointment);
            appointmentDto.setUserDto(user);
            appointmentService.save(appointmentDto);

            result.put("message", "Appointment was successful");
            status = gson.toJson(result);
            return new ResponseEntity(status, HttpStatus.OK);

        } catch (AppointmentDateInvalid | InvalidDoctorInfo error) {
            result.put("message", error.getMessage());
            status = gson.toJson(result);
            return new ResponseEntity(status, HttpStatus.BAD_REQUEST);
        }
    }


    private AppointmentDto validateAppointment(AppointmentPojo appointment) throws AppointmentDateInvalid, InvalidDoctorInfo {
        String specialization = appointment.getSpecialization();
        String institution = appointment.getInstitution();
        Optional<Doctor> doctor = doctorService.findByInstitutionAndSpecialization(institution, specialization);
        if (!doctor.isPresent()) {
            throw new InvalidDoctorInfo("There is no " + specialization + " working in " + institution);
        }

        Optional<AppointmentDto> appointmentByDoctor = appointmentService.findAppointmentByDoctorAndDateAndTime(doctor.get(), appointment.getDate(),appointment.getTime());
        if (appointmentByDoctor.isPresent()) {
            throw new AppointmentDateInvalid(appointment.getDate()+" "+appointment.getTime() + " is taken.");
        }


        AppointmentDto appointmentDto = appointmentDtoBuilder.appointmentToDto(appointment);

        appointmentDto.setDoctor(doctor.get());
        return appointmentDto;
    }


    @RequestMapping(value = "/timePanel",method = RequestMethod.GET)
    public String getTimePanel(){
        return "chooseTimePanel";
    }


    @RequestMapping(value = "/availableHours",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AppointmentDto> getAvailableHours(@RequestBody AppointmentPojo appointmentPojo){

        Optional<Doctor> doctor = doctorService.findByInstitutionAndSpecialization(appointmentPojo.getInstitution(),appointmentPojo.getSpecialization());

        if(doctor.isPresent()) {
            List<AppointmentDto> appointmentsByDate = appointmentService.findAppointmentsByDateAndDoctor(appointmentPojo.getDate(),doctor.get());
            return  appointmentsByDate;
        }

        return new ArrayList<AppointmentDto>();

    }
}
