package com.mmarciniak.reservationservice.repository;

import com.mmarciniak.reservationservice.entity.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment,Long> {
}
