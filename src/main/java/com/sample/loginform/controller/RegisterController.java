package com.sample.loginform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.loginform.model.Register;
import com.sample.loginform.services.RegisterServices;

@RestController
@RequestMapping("/Register")
@CrossOrigin(origins = "http://localhost:3001")
public class RegisterController {
    @Autowired
    private RegisterServices serv;

    @PostMapping("/registration")
    public Register saveDetails(@RequestBody Register register) {
        return serv.saveDetails(register);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Register register) {
        String response = serv.authenticate(register.getUsername(), register.getPassword());
        if ("Login successful".equals(response)) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body(response);
        }
    }
}
