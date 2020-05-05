package com.mmarciniak.reservationservice.service;

import com.mmarciniak.reservationservice.entity.Doctor;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public interface DoctorService {
    List<Doctor> findAll();
    Optional<Doctor> findById(Long id);
    Doctor saveDoctor(Doctor doctor);
    Optional<Doctor> findByInstitutionAndSpecialization(String institution,String specialization);
}
