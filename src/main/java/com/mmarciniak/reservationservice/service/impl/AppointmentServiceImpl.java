package com.mmarciniak.reservationservice.service.impl;

import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.entity.UserDto;
import com.mmarciniak.reservationservice.repository.AppointmentRepository;
import com.mmarciniak.reservationservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<AppointmentDto> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    @Override
    public AppointmentDto save(AppointmentDto appointmentDto) {
        return appointmentRepository.save(appointmentDto);
    }

    @Override
    public Optional<AppointmentDto> findAppointmentByDoctor(Doctor doctor) {
        return appointmentRepository.findAppointmentByDoctor(doctor);
    }

    @Override
    public Optional<AppointmentDto> findAppointmentByDoctorAndDateAndTime(Doctor doctor, LocalDate date, LocalTime time) {
        return appointmentRepository.findAppointmentByDoctorAndDateAndTime(doctor,date,time);
    }


    @Override
    public List<AppointmentDto> findUserAppointments(UserDto user) {
        return appointmentRepository.findAppointmentDtosByUserDto(user);
    }

    @Override
    public List<AppointmentDto> findAppointmentsByDateAndDoctor(LocalDate date, Doctor doctor) {
        return appointmentRepository.findAppointmentDtosByDateAndDoctor(date,doctor);
    }



    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
