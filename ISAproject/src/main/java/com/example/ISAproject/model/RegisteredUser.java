package com.example.ISAproject.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RegisteredUser extends User{

    @Column
    private int points;
    @Column
    private String category;
    @Column
    private String benefits;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public int getPoints() { return points; }

    public void setPoints(int points) {this.points = points;}

    public String getCategory() {return category;}

    public void setCategory(String category) {this.category = category;}

    public String getBenefits() {return benefits;}

    public void setBenefits(String benefits) {this.benefits = benefits;}

    public RegisteredUser() { }

    public RegisteredUser(String username, String password, String email, String firstName, String lastName,
                String mobile, String city, String state, String sex, String profession,
                String organizationInformation, boolean enabled, String role,
                List<Authority> authorities, List<Appointment> appointments) {
        super();
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setMobile(mobile);
        setCity(city);
        setState(state);
        setSex(sex);
        setProfession(profession);
        setOrganizationInformation(organizationInformation);
        setEnabled(enabled);
        setRole(role);
        setAuthorities(authorities);
        setAppointments(appointments);
    }

    public RegisteredUser(String username, String password, String email, String firstName, String lastName,
                          String mobile, String city, String state, String sex, String profession,
                          String organizationInformation, boolean enabled, String role,
                          List<Authority> authorities) {
        super();
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setMobile(mobile);
        setCity(city);
        setState(state);
        setSex(sex);
        setProfession(profession);
        setOrganizationInformation(organizationInformation);
        setEnabled(enabled);
        setRole(role);
        setAuthorities(authorities);
        this.setPoints(0);
        this.setBenefits("Redovan");
        this.setCategory("Redovan");

    }
}
