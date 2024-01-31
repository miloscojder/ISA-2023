package com.example.ISAproject.controllers;

import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    //Prikaz svih termina
    @RequestMapping(value="api/appointments/{id}",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Appointment>> findAllFreeAppointementByCenter(@PathVariable Long id)
    {
        List<Appointment> appointments= this.appointmentService.findAllAvailableTermsByCenter(id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

}
