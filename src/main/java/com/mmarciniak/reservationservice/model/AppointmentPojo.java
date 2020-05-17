package com.mmarciniak.reservationservice.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentPojo {

    private String specialization;
    private LocalDate date;
    private LocalTime time;
    private String institution;
    private String status;

    public AppointmentPojo() {
    }

    public AppointmentPojo(String specialization, LocalDate date, LocalTime time, String institution, String status) {
        this.specialization = specialization;
        this.date = date;
        this.time = time;
        this.institution = institution;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
