package com.example.ISAproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stuff extends User{
    @OneToMany //(cascade = CascadeType.ALL,orphanRemoval = true)
 //   @JsonIgnore
    private List<Appointment> appointments;


}
