package com.example.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Stuff extends User{
	
	@OneToOne
    private ProfileCenter profileCenter;
	
	
	
	
}
