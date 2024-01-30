package com.example.ISAproject.service;

import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
