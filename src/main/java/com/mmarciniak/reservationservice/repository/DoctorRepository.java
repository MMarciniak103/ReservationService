package com.mmarciniak.reservationservice.repository;

import com.mmarciniak.reservationservice.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor,Long> {

    Optional<Doctor> findDoctorByInstitutionAndSpecialization(String institution, String specialization);
}
