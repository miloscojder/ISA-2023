package com.example.ISAproject.service;

import com.example.ISAproject.dto.ScheduleTermDTO;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private CompanyService companyService;

    public Appointment findById(Long id){
        Optional<Appointment> appointmentOptional = this.appointmentRepository.findById(id);
        if (!appointmentOptional.isPresent()) {
            return null;
        }
        return appointmentOptional.get();
    }
    public Appointment scheduleTerm(ScheduleTermDTO dto){
        RegisteredUser registeredUser = this.registeredUserService.findById(dto.getRegisteredUserId());
        Company company = this.companyService.findById(dto.getCompanyId());
        Appointment appointment = this.findById(dto.getAppointmentId());

        appointment.setFree(false);
        appointment.setRegisteredUserCome(false);
        appointment.setRegisteredUser(registeredUser);
        appointment.setCompany(company);
        appointment.setEquipments(dto.getEquipments());

        return this.appointmentRepository.save(appointment);
    }
}
