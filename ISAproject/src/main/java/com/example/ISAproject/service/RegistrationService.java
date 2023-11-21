package com.example.ISAproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.ISAproject.model.User;
import com.example.ISAproject.repository.UserRepository;

import java.util.List;

@Service
public class RegistrationService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getByUsername(String username)
    {
        User user = userRepository.findByUsername(username);
        return  user;
    }

    public User registration(User user)
    {
        List<User> listOfAll = this.userRepository.findAll();
        System.out.println("Pozvali smo metodu registracije");
        if(userRepository.findByUsername(user.getUsername()) != null)
        {
            System.out.println("Username Already exists! ");
            return null;
        }
        else if (user.getUsername().isEmpty() || user.getFirstName().isEmpty() || user.getLastName().isEmpty() ||
                user.getFirstName().isEmpty())
        {
            System.out.println("There is not enough data! ");
            return null;
        }

/*
        //Automatsko prosledjivanje novog ID-ja
        Long id = (long)0;
        for(User u: listOfAll)
        {
            id = u.getId();
        }
        id = id + 1;
        user.setId(id);

        user.setPassword(passwordEncoder.encode(user.getPassword()));*/
        User user2 = this.userRepository.save(user);
        
        return user2;
    }


    public List<User> findAll()
    {
        return this.userRepository.findAll();
    }



}