package com.gussoft.medicabackend.controller;

import com.gussoft.medicabackend.models.dto.Email;
import com.gussoft.medicabackend.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {

    @Autowired
    private EmailService mailService;

    @PostMapping("/sendMail")
    public ResponseEntity<Object> sendMail(@RequestBody Email e){

        String message = e.getBody() +"\n\n Datos de contacto: " + "\nNombre: " + e.getName() + "\nE-mail: " + e.getMail();
        mailService.setMailSender(e.getFrom(), e.getTo(), e.getSubject(), message);

        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
