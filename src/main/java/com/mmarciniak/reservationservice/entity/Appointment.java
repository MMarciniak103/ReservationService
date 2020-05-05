package com.mmarciniak.reservationservice.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    private UserDto userDto;

    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    private LocalDate date;

    private String institution;

    public Appointment() {
    }

    public Appointment(Long id, UserDto userDto, Doctor doctor, LocalDate date, String institution) {
        this.id = id;
        this.userDto = userDto;
        this.doctor = doctor;
        this.date = date;
        this.institution = institution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
