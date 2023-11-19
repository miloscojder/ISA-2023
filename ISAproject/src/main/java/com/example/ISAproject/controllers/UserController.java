package com.example.ISAproject.controllers;

import com.example.ISAproject.dto.UserDTO;
import com.example.ISAproject.model.User;
import com.example.ISAproject.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private EmailService emailService;

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



}