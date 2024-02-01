package com.example.ISAproject.service;

import com.example.ISAproject.dto.ScheduleTermDTO;
import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.Equipment;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.AppointmentRepository;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        System.out.println("Usao je u metodu scheduleTerm"+ dto.getRegisteredUserId());
/*
        List<Equipment> equipments = this.equipmentService.getEquipmentByIds(dto.getEquipmentIds());
        for (Equipment e: equipments){
            e.setAppointment(appointment);
            this.equipmentService.save(e);
        }*/

        appointment.setFree(false);
        appointment.setRegisteredUserCome(false);
        appointment.setRegisteredUser(registeredUser);
        appointment.setCompany(company);
        appointment.setEquipments(this.equipmentService.getEquipmentByIds(dto.getEquipmentIds()));


        Appointment app = this.appointmentRepository.save(appointment);
        System.out.println("Ovo je taj termin koji je rezervisan"+ app.getRegisteredUser().getFirstName());
        return app;
    }
    //Da li user ima 3 penala
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
        LocalDateTime now = LocalDateTime.now();

        // Pronađi sve slobodne termine za određenu kompaniju i filtriraj one koji su prosli
        List<Appointment> availableTerms = this.appointmentRepository.findByIsFreeAndCompanyId(true, id);
        List<Appointment> futureAvailableTerms = new ArrayList<>();

        for (Appointment appointment : availableTerms) {
            if (appointment.getReservationStart().isAfter(now)) {
                futureAvailableTerms.add(appointment);
            }
        }

        return futureAvailableTerms;
    }

    public List<Appointment> findAllTermsByRegisteredUser(Long id){
        List<Appointment> allTerms = appointmentRepository.findAll();
        List<Appointment> foundedTerms = new ArrayList<>();

        for(Appointment appointment: allTerms){
            if (appointment.getRegisteredUser() != null && appointment.getRegisteredUser().getId() == id){
                foundedTerms.add(appointment);
            }
        }
        return foundedTerms;
    }

    //Otkazivanje zakazanog termina po id-u termina
    @Transactional
    public Appointment cancelAppointment(Long id) {
        System.out.println("Pokrenula se f-ja za otkazivanje termina..."+ id);
        Optional<Appointment> appointment = this.appointmentRepository.findById(id);
        if (!appointment.isPresent()) {
            return null;
        }


        Appointment appointment1 = appointment.get();

        RegisteredUser registeredUser = this.registeredUserService.findById(appointment1.getRegisteredUser().getId());

        if (appointment1.getRegisteredUser() != null) {

            LocalDateTime currentDateTime = LocalDateTime.now();
            LocalDateTime appointmentStart = appointment1.getReservationStart();
            Duration timeDifference = Duration.between(currentDateTime, appointmentStart);

            if (timeDifference.toHours() < 24) {
                registeredUser.setPoints(registeredUser.getPoints() + 2);
            }else {
                registeredUser.setPoints(registeredUser.getPoints() + 1);
            }

            appointment1.setRegisteredUser(null);
            appointment1.setFree(true);
            appointment1.getEquipments().clear();

        }

        return this.appointmentRepository.save(appointment1);

    }
}
