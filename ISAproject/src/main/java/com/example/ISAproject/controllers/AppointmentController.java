package com.example.ISAproject.controllers;

import com.example.ISAproject.dto.ScheduleTermDTO;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    //Zakazivanje termina za preuzizmanje opreme
    @RequestMapping(value="api/scheduleTerm",method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasRole('REGISTERED_USER')")
    public ResponseEntity<Appointment>  scheduleNewTerm(@RequestBody ScheduleTermDTO dto)throws Exception{

        Appointment updatedAppointment = this.appointmentService.scheduleTerm(dto);
        return  new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
    }
    //Prikaz svih termina koje je zakazao regisrovani korisnik
    @RequestMapping(value="api/scheduledTerm/{id}",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<Appointment>> findAllAppointmentByRegisteredUser(@PathVariable Long id)
    {
        List<Appointment> appointments= this.appointmentService.findAllTermsByRegisteredUser(id);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    //Otkazivanje zakazanog termina
    @RequestMapping(value="api/cancelTerm",method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Appointment>  cancelTerm(@RequestBody ScheduleTermDTO dto) {
        System.out.println("Stigli smo do kntrolera..."+ dto.getAppointmentId());
        Appointment updatedAppointment = this.appointmentService.cancelAppointment(dto.getAppointmentId());
        if(updatedAppointment.getRegisteredUser()!=null){
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
        return new ResponseEntity<>(updatedAppointment,HttpStatus.OK);
    }
}
