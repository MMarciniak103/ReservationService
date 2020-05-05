package com.mmarciniak.reservationservice.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "appointment")
public class AppointmentDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDto userDto;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;


    private LocalDate date;



    public AppointmentDto() {
    }

    public AppointmentDto(Long id, UserDto userDto, Doctor doctor, LocalDate date) {
        this.id = id;
        this.userDto = userDto;
        this.doctor = doctor;
        this.date = date;
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

}
