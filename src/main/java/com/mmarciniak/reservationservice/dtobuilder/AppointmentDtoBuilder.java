package com.mmarciniak.reservationservice.dtobuilder;

import com.mmarciniak.reservationservice.entity.AppointmentDto;
import com.mmarciniak.reservationservice.model.AppointmentPojo;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDtoBuilder {


    public AppointmentDto appointmentToDto(AppointmentPojo appointment){
        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setDate(appointment.getDate());
        appointmentDto.setTime(appointment.getTime());
        appointment.setInstitution(appointment.getInstitution());
        appointment.setSpecialization(appointment.getSpecialization());

        return appointmentDto;
    }
}
