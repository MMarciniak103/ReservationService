package com.mmarciniak.reservationservice.controller;

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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public String loadMainPage(HttpServletRequest request,Model model)
    {
        List<Doctor> doctors = doctorService.findAll();
        model.addAttribute("doctors",doctors);

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            if (inputFlashMap.containsKey("appointmentError")) {
                String message = (String) inputFlashMap.get("appointmentError");
                model.addAttribute("appointmentError", message);
            }
            else if (inputFlashMap.containsKey("appointmentSuccess")){
                String message = (String) inputFlashMap.get("appointmentSuccess");
                model.addAttribute("appointmentSuccess",message);
            }
        }


        return "webpage";
    }


    @RequestMapping(value = "/makeAppointment",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String makeAppointment(@RequestBody AppointmentPojo appointment, HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes){

        String userName = httpServletRequest.getUserPrincipal().getName();

        UserDto user = userService.getUserByName(userName).get();


        try {
            AppointmentDto appointmentDto = validateAppointment(appointment);
            appointmentDto.setUserDto(user);
            appointmentService.save(appointmentDto);

        } catch (AppointmentDateInvalid | InvalidDoctorInfo error) {
//                re.addAttribute("appointmentError",error.getMessage());
            redirectAttributes.addFlashAttribute("appointmentError",error.getMessage());
        }

//        model.addAttribute("appointmentSuccess","Appointment was successful");
        redirectAttributes.addFlashAttribute("appointmentSuccess","Appointment was successful");


        return "redirect:/";
    }


    private AppointmentDto validateAppointment(AppointmentPojo appointment) throws AppointmentDateInvalid, InvalidDoctorInfo {
        String specialization = appointment.getSpecialization();
        String institution = appointment.getInstitution();
        Optional<Doctor> doctor = doctorService.findByInstitutionAndSpecialization(institution, specialization);
        if(!doctor.isPresent()){
            throw new InvalidDoctorInfo("There is no "+specialization+" working in "+institution);
        }

        Optional<AppointmentDto> appointmentByDoctor = appointmentService.findAppointmentByDoctorAndDate(doctor.get(), appointment.getDate());
        if(appointmentByDoctor.isPresent()){
            throw new AppointmentDateInvalid(appointment.getDate()+" is taken.");
        }


        AppointmentDto appointmentDto = appointmentDtoBuilder.appointmentToDto(appointment);

        appointmentDto.setDoctor(doctor.get());
        return appointmentDto;
    }
}
