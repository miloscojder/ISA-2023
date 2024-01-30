package com.example.ISAproject.dto;

import com.example.ISAproject.model.Appointment;
import com.example.ISAproject.model.Company;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.service.CompanyService;

import java.util.List;

public class AppointmentDTO {
    private Long id;
    private String date;
    private int duration;
    private boolean isFree;
    private String reservationStart;
    private String reservationEnd;
    private RegisteredUser registeredUser;
    private Company company;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Long id, String date, int duration, boolean isFree, String reservationStart,
                          String reservationEnd, RegisteredUser registeredUser, Company company,
                          List<Appointment> appointments) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.isFree = isFree;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.registeredUser = registeredUser;
        this.company = company;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(String reservationStart) {
        this.reservationStart = reservationStart;
    }

    public String getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(String reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public RegisteredUser getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(RegisteredUser registeredUser) {
        this.registeredUser = registeredUser;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    private List<Appointment> appointments;
}
