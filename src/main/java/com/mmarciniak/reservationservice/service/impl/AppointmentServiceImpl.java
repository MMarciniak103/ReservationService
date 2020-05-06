package com.mmarciniak.reservationservice.service.impl;

import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.entity.UserDto;
import com.mmarciniak.reservationservice.repository.AppointmentRepository;
import com.mmarciniak.reservationservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public Optional<AppointmentDto> findAppointmentByDoctorAndDate(Doctor doctor, LocalDate date) {
        return appointmentRepository.findAppointmentByDoctorAndDate(doctor,date);
    }

    @Override
    public List<AppointmentDto> findUserAppointments(UserDto user) {
        return appointmentRepository.findAppointmentDtosByUserDto(user);
    }

    @Override
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }
}
