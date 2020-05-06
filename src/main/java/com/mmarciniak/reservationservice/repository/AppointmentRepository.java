package com.mmarciniak.reservationservice.repository;

import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.entity.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentDto,Long> {

    Optional<AppointmentDto> findAppointmentByDoctor(Doctor doctor);
    Optional<AppointmentDto> findAppointmentByDoctorAndDateAndTime(Doctor doctor, LocalDate date, LocalTime time);
    List<AppointmentDto> findAppointmentDtosByUserDto(UserDto user);
    void deleteById(Long id);

}
