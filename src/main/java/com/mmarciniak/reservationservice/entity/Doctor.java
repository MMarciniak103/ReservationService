package com.mmarciniak.reservationservice.entity;

import javax.persistence.*;
import javax.validation.Constraint;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization;

    private String institution;

    @Column(name = "working_from")
    private int workingFrom;

    @Column(name = "working_to")
    private int workingTo;

    public Doctor() {
    }

    public Doctor(String specialization, String institution, int workingFrom, int workingTo) {
        this.specialization = specialization;
        this.institution = institution;
        this.workingFrom = workingFrom;
        this.workingTo = workingTo;
    }

//    public Doctor(String specialization, String institution) {
//        this.specialization = specialization;
//        this.institution = institution;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public int getWorkingFrom() {
        return workingFrom;
    }

    public void setWorkingFrom(int workingFrom) {
        this.workingFrom = workingFrom;
    }

    public int getWorkingTo() {
        return workingTo;
    }

    public void setWorkingTo(int workingTo) {
        this.workingTo = workingTo;
    }
}
