package com.mmarciniak.reservationservice.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentPojo {

    private String specialization;
    private LocalDate date;
    private LocalTime time;
    private String institution;

    public AppointmentPojo() {
    }

    public AppointmentPojo(String specialization, LocalDate date, String institution,LocalTime time) {
        this.specialization = specialization;
        this.date = date;
        this.time = time;
        this.institution = institution;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
