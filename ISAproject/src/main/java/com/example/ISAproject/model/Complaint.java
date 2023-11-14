package com.example.ISAproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private boolean isForCenter;
	@Column
	private boolean isForStuff;
	@Column
	private String title;
	@Column
	private String content;
	
	@ManyToOne
	private Admin admin;
	
}
