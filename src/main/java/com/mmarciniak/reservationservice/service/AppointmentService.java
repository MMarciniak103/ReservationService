package com.mmarciniak.reservationservice.service;

import com.mmarciniak.reservationservice.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AppointmentService{

    Optional<Appointment> findById(Long id);
    Appointment save(Appointment appointment);
}
