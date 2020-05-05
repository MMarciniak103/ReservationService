package com.mmarciniak.reservationservice.repository;

import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentDto,Long> {

    Optional<AppointmentDto> findAppointmentByDoctor(Doctor doctor);
    Optional<AppointmentDto> findAppointmentByDoctorAndDate(Doctor doctor, LocalDate date);

}
