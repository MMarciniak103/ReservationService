package com.mmarciniak.reservationservice.service;

import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.entity.UserDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public interface AppointmentService{

    Optional<AppointmentDto> findById(Long id);
    AppointmentDto save(AppointmentDto appointmentDto);
    Optional<AppointmentDto> findAppointmentByDoctor(Doctor doctor);
    Optional<AppointmentDto> findAppointmentByDoctorAndDateAndTime(Doctor doctor, LocalDate date, LocalTime time);
    List<AppointmentDto> findUserAppointments(UserDto user);
    List<AppointmentDto> findAppointmentsByDateAndDoctor(LocalDate date,Doctor doctor);
    void deleteAppointmentById(Long id);

}
