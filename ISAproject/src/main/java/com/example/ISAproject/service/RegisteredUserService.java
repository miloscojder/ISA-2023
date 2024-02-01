package com.example.ISAproject.service;

import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RegisteredUserService {
    @Autowired
    private RegisteredUserRepository registeredUserRepository;

    public RegisteredUser findById(Long id)
    {
        Optional<RegisteredUser> opt=this.registeredUserRepository.findById(id);
        if(!opt.isPresent())
        {
            return null;
        }

        return opt.get();
    }
    public RegisteredUser save(RegisteredUser newRegUser) {
        return this.registeredUserRepository.save(newRegUser);
    }

    @Scheduled(cron = "0 0 0 1 * *") // svaki prvi dan u mesecu
    //@Scheduled(cron = "0 * * * * *") //svaki minut
    public void myMethod() throws ParseException {

        System.out.println("Scheduled method executed at: " + LocalDateTime.now());

        List<RegisteredUser> registeredUsers= this.registeredUserRepository.findAll();
        for(RegisteredUser registeredUser: registeredUsers)
        {
            registeredUser.setPoints(0);
            this.registeredUserRepository.save(registeredUser);
        }
    }

}
