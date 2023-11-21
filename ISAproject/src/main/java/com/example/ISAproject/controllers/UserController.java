package com.example.ISAproject.controllers;

import com.example.ISAproject.dto.UserDTO;
import com.example.ISAproject.model.User;
import com.example.ISAproject.service.EmailService;
import com.example.ISAproject.service.RegistrationService;
import com.example.ISAproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private EmailService emailService;

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private UserService userService;


    @GetMapping
    public String getNew(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }


    @PostMapping("/signup/async")
    public String signUpAsync(@RequestBody UserDTO userDTO){

        //slanje emaila
        try {
            System.out.println("Thread id: " + Thread.currentThread().getId());
            emailService.sendNotificaitionAsync(userDTO);
        }catch( Exception e ){
            logger.info("Greska prilikom slanja emaila: " + e.getMessage());
        }

        return "success";
    }

    @RequestMapping(value="/api/confirm-registration/{id}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public void confirmRegistrationForUser(@PathVariable Long id) {
        System.out.println("Id usera za potvrdu je: " + id);
        System.out.println("Id usera za potvrdu je: " + this.userService.findById(id).getUsername());
        this.userService.activateById(id);
    }


}