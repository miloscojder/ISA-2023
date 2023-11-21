package com.example.ISAproject.dto;

import com.example.ISAproject.model.Authority;
import com.example.ISAproject.model.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

public class UserDTO {
	private Long id;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String mobile;

	private String city;
	private String state;
	private String sex;
	private String profession;
	private String organizationInformation;
	private boolean enabled;
	private String role;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getOrganizationInformation() {
		return organizationInformation;
	}

	public void setOrganizationInformation(String organizationInformation) {
		this.organizationInformation = organizationInformation;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public UserDTO(Long id, String username, String password, String email, String firstName, String lastName, String mobile, String city, String state, String sex, String profession, String organizationInformation, boolean enabled, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
		this.sex = sex;
		this.profession = profession;
		this.organizationInformation = organizationInformation;
		this.enabled = enabled;
		this.role = role;
	}

	public UserDTO(User user) {
		super();
	
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.mobile = user.getMobile();
		this.id=user.getId();
		this.role=user.getRole();
		
	}
	public UserDTO() {}
	
	
}
