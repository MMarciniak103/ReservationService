package com.mmarciniak.reservationservice.model;

import java.time.LocalDate;

public class AppointmentPojo {

    private String specialization;
    private LocalDate date;
    private String institution;

    public AppointmentPojo() {
    }

    public AppointmentPojo(String specialization, LocalDate date, String institution) {
        this.specialization = specialization;
        this.date = date;
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
}
