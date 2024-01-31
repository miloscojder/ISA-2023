package com.example.ISAproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Stuff extends User{
    @OneToMany //(cascade = CascadeType.ALL,orphanRemoval = true)
 //   @JsonIgnore
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn (name = "company_id")
    private Company company;
    public Stuff(String username, String password, String email, String firstName, String lastName, String mobile, String city, String state, String sex, String profession, String organizationInformation, boolean enabled, Timestamp lastPasswordResetDate, String role, List<Authority> authorities, List<Appointment> appointments) {
        super(username, password, email, firstName, lastName, mobile, city, state, sex, profession, organizationInformation, enabled, lastPasswordResetDate, role, authorities);
        this.appointments = appointments;
    }

    public Stuff() {

    }
}
