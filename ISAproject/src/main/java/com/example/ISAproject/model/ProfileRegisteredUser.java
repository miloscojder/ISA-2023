package com.example.ISAproject.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ProfileRegisteredUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private RegisteredUser registeredUser;
	@Column
	private int points;
	@Column
	private String category;
	@Column
	private String benefits;

	//@Column
	//private List<String> scheduledAppointments;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}
	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	public ProfileRegisteredUser(Long id, RegisteredUser registeredUser, int points, String category, String benefits) {
		super();
		this.id = id;
		this.registeredUser = registeredUser;
		this.points = points;
		this.category = category;
		this.benefits = benefits;
	}
	
	
	
	
	
	
}
