package com.example.ISAproject.service;

import com.example.ISAproject.dto.UserDTO;
import com.example.ISAproject.exception.ResourceConflictException;
import com.example.ISAproject.model.RegisteredUser;
import com.example.ISAproject.model.User;
import net.bytebuddy.asm.Advice;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;
    @Async
    public void sendNotificaitionAsync(UserDTO userRequest) throws MailException, InterruptedException{
        System.out.println("Async metoda se izvrsava u drugom Threadu u odnosu na prihvaceni zahtev. Thread id: " + Thread.currentThread().getId());
        //Simulacija duze aktivnosti da bi se uocila razlika
        Thread.sleep(10000);
        System.out.println("Slanje emaila...");
        //deo iz Authentication controller
        User existUser = this.userService.findByUsername(userRequest.getUsername());

        if (existUser != null) {
            throw new ResourceConflictException(userRequest.getId(), "Username already exists");
        }

        RegisteredUser user = this.userService.save(userRequest);

        System.out.println("Ovo je id regUesera"+ user.getFirstName()+ user.getId() );

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject("Potvrdite svoju registraciju");
        mail.setText("Pozdrav " + user.getFirstName() + ", \n Kliknite na naredni kod kako biste aktivirali svoj nalog"+"\n http://localhost:4200/confirm-registration/"+user.getId()+"\n\n Hvala što želiš da postaneš naš član " );
        javaMailSender.send(mail);

        System.out.println("Email je poslat!");
    }


}
