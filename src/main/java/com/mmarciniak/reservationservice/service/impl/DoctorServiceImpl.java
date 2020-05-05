package com.mmarciniak.reservationservice.service.impl;

import com.mmarciniak.reservationservice.entity.Doctor;
import com.mmarciniak.reservationservice.repository.DoctorRepository;
import com.mmarciniak.reservationservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> findByInstitutionAndSpecialization(String institution, String specialization) {
        return doctorRepository.findDoctorByInstitutionAndSpecialization(institution,specialization);
    }
}
