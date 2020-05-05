package com.mmarciniak.reservationservice;

import com.mmarciniak.reservationservice.dtobuilder.UserDtoBuilder;
import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.model.UserPojo;
import com.mmarciniak.reservationservice.repository.DoctorRepository;
import com.mmarciniak.reservationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OnStartHandler {

    private UserRepository userRepository;
    private UserDtoBuilder userDtoBuilder;
    private DoctorRepository doctorRepository;

    @Autowired
    public OnStartHandler(UserRepository userRepository, UserDtoBuilder userDtoBuilder, DoctorRepository doctorRepository) {
        this.userRepository = userRepository;
        this.userDtoBuilder = userDtoBuilder;
        this.doctorRepository = doctorRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fill(){
        UserPojo userPojo1 = new UserPojo("tom","123","ROLE_ADMIN");
        UserPojo userPojo2 = new UserPojo("mark","123","ROLE_CUSTOMER");

        userRepository.save(userDtoBuilder.userToUserDto(userPojo1));
        userRepository.save(userDtoBuilder.userToUserDto(userPojo2));


        Doctor dentist = new Doctor("dentist","Dental Center");
        Doctor pediatrician = new Doctor("pediatrician","City Hospital");
        Doctor orthopaedist = new Doctor("orthopaedist","Sport Center");

        Set<Doctor> doctors = new HashSet<>(){
            {
                add(dentist);
                add(pediatrician);
                add(orthopaedist);
            }
        };

        doctorRepository.saveAll(doctors);

    }
}
