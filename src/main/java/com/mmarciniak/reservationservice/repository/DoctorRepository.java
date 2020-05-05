package com.mmarciniak.reservationservice.repository;

import com.mmarciniak.reservationservice.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}
