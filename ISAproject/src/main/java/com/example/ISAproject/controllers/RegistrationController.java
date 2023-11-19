package com.example.ISAproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.UserRepository;
import com.example.ISAproject.service.RegistrationService;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RegistrationController
{
    @Autowired
    RegistrationService registrationService;
    @Autowired
    UserRepository userRepository;
    

    @RequestMapping(value="api/registration",method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> registration(@RequestBody User user)
    {
        //User savedUser=this.registrationService.registration(user);
    	User savedUser=this.userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Prikaz svi korisnika
    @RequestMapping(value="api/users",method = RequestMethod.GET,produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<List<User>> findAll()
    {
        List<User> users=this.registrationService.findAll();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
