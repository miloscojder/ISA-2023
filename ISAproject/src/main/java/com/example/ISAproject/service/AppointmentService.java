package com.example.ISAproject.service;

import com.example.ISAproject.dto.ScheduleTermDTO;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Autowired
    private EquipmentService equipmentService;

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
        appointment.setEquipments(this.equipmentService.getEquipmentByIds(dto.getEquipmentIds()));

        return this.appointmentRepository.save(appointment);
    }
    public boolean whetherRegisteredUserHasThreePenalties(Long userId){
        RegisteredUser registeredUser=this.registeredUserService.findById(userId);
        if(registeredUser.getPoints()>2)
        {
            return true;
        }
        return false;

    }
    //Prikazivanje slobodnih i zakazanih termina
    public List<Appointment> findFreeTerms(boolean isFree)
    {
        List<Appointment> all_terms =  this.appointmentRepository.findAll();
        List<Appointment> free_terms = new ArrayList<>();
        List<Appointment> reserved_terms = new ArrayList<>();

        for(Appointment appointment: all_terms)
        {
            if(appointment.isFree() == true)
            {
                free_terms.add(appointment);
            }
            else
            {
                reserved_terms.add(appointment);
            }
        }

        if(isFree == true)
        {
            return free_terms;
        }
        else
        {
            return reserved_terms;
        }
    }
    public List<Appointment> findAllAvailableTerms() {
        return this.appointmentRepository.findByIsFree(true);
    }
    public List<Appointment> findAllAvailableTermsByCenter(Long id) {
        return this.appointmentRepository.findByIsFreeAndCompanyId(true, id);
    }
}
