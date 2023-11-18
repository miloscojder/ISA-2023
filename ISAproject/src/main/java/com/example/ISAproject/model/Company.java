package com.example.ISAproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String description;
    @Column
    private Long averageGradeCompany;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointments;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Stuff> stuffs;
//Oprema koju kompanija ima na stanju
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Equipment> equipments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAverageGradeCompany() {
        return averageGradeCompany;
    }

    public void setAverageGradeCompany(Long averageGradeCompany) {
        this.averageGradeCompany = averageGradeCompany;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Stuff> getStuffs() {
        return stuffs;
    }

    public void setStuffs(List<Stuff> stuffs) {
        this.stuffs = stuffs;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public Company(Long id, String name, String address, String description, Long averageGradeCompany,
                   List<Appointment> appointments, List<Stuff> stuffs, List<Equipment> equipments) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.averageGradeCompany = averageGradeCompany;
        this.appointments = appointments;
        this.stuffs = stuffs;
        this.equipments = equipments;
    }
}
