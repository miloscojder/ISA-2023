package com.example.ISAproject.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ISAproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	 User findByUsername(String username);
	 
	 //User getByUsername(String username);

	 User getByFirstName(String firstName);

	//public List<User> getUsersByPartOfUsername(String part_of_username);
	public ArrayList<User> getUsersByUsername(String username);
}


