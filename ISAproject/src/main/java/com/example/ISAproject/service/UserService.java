package com.example.ISAproject.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ISAproject.dto.UserDTO;
import com.example.ISAproject.model.Authority;
import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
	public User findById(Long id) throws AccessDeniedException {
		return userRepository.findById(id).orElseGet(null);
	}

	public List<UserDTO> findAll() throws AccessDeniedException {
		List<User> users=userRepository.findAll();
		List<UserDTO> usersDTO=new ArrayList<>();
	 for (User u : users) {
		 if(!(u.getRole().equalsIgnoreCase("SysAdmin") || u.getRole().equalsIgnoreCase("Admin"))) {
			 UserDTO dto=new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail(),u.getFirstName(),u.getLastName(), u.getMobile(),u.getCity(), u.getState(), u.getSex(), u.getProfession(), u.getOrganizationInformation(), u.isEnabled(), u.getRole());
			usersDTO.add(dto);
		 }
			
		
	 }
	 return usersDTO;
	}

	
	public User save(UserDTO userRequest) {
		List<User> listOfAll = this.userRepository.findAll();
		User u = new User();
		u.setUsername(userRequest.getUsername());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isti password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

		u.setEmail(userRequest.getEmail());
		u.setFirstName(userRequest.getFirstName());
		u.setLastName(userRequest.getLastName());
		u.setMobile(userRequest.getMobile());
		u.setCity(userRequest.getCity());
		u.setState(userRequest.getState());
		u.setSex(userRequest.getSex());
		u.setProfession(userRequest.getProfession());
		u.setOrganizationInformation(userRequest.getOrganizationInformation());
		u.setEnabled(false);
		//u.setRole(userRequest.getRole());
		u.setRole("RegisteredUser");
		//u.setLastPasswordResetDate();

		//Automatsko prosledjivanje novog ID-ja
		Long id = (long)0;
		for(User c: listOfAll)
		{
			id = c.getId();
		}
		id = id + 1;
		u.setId(id);
		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		List<Authority> authorities=new ArrayList<>();
		//User newUser=new User();
		System.out.println("id iz userService"+ u.getId());
		System.out.println("Ime iz userService"+ u.getFirstName());
		User newUser = this.userRepository.save(u);
		return newUser;
	}
	public User activateById(Long id) {
		Optional<User> UserOpt= Optional.ofNullable(this.findById(id));
		if(!UserOpt.isPresent()) {
			return null;
		}
		User user=UserOpt.get();
		user.setEnabled(true);
		User newUser = this.userRepository.save(user);
		//client.setEnabled(true);
		return newUser;
	}
}
