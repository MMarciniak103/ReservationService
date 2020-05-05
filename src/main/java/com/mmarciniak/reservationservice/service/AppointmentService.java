package com.mmarciniak.reservationservice.service;

import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.entity.Doctor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public interface AppointmentService{

    Optional<AppointmentDto> findById(Long id);
    AppointmentDto save(AppointmentDto appointmentDto);
    Optional<AppointmentDto> findAppointmentByDoctor(Doctor doctor);
    Optional<AppointmentDto> findAppointmentByDoctorAndDate(Doctor doctor, LocalDate date);
}
