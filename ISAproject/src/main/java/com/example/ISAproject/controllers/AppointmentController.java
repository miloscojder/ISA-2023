package com.example.ISAproject.controllers;

import com.example.ISAproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

}
