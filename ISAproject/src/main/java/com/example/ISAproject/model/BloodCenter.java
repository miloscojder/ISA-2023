package com.example.ISAproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloodCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String adress;
	@Column
	private String city;
	@Column
	private String startWork;
	@Column
	private String endWork;
	@Column
	private Long grade;
	@Column
	private String description;
	/*@Column
	private List<DonationTerms> reservedTerms;
	@Column
	private List<DonationTerms> freeTerms;*/
}
