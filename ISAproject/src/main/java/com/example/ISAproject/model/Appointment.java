package com.example.ISAproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime date;

    @Column
    private int duration;

    @Column(name = "isFree", nullable = false)
    private boolean isFree;

    @Column(name = "reservationStart", nullable = false)
    private LocalDateTime reservationStart;

    @Column(name = "reservationEnd", nullable = false)
    private LocalDateTime reservationEnd;

    @Column
    private boolean isRegisteredUserCome;

    @ManyToOne
    private RegisteredUser registeredUser;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    private Calendar calendar;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Equipment> equipments;

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public LocalDateTime getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(LocalDateTime reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDateTime getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDateTime reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public boolean isRegisteredUserCome() {
        return isRegisteredUserCome;
    }

    public void setRegisteredUserCome(boolean registeredUserCome) {
        isRegisteredUserCome = registeredUserCome;
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

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Appointment() {}

    public Appointment(Long id, LocalDateTime date, int duration, boolean isFree, LocalDateTime reservationStart,
                       LocalDateTime reservationEnd, boolean isRegisteredUserCome, RegisteredUser registeredUser,
                       Company company, Calendar calendar, List<Equipment> equipments) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.isFree = isFree;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.isRegisteredUserCome = isRegisteredUserCome;
        this.registeredUser = registeredUser;
        this.company = company;
        this.calendar = calendar;
        this.equipments = equipments;
    }
}
