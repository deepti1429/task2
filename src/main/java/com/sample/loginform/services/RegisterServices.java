package com.sample.loginform.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.loginform.Repository.RegisterRepo;
import com.sample.loginform.model.Register;

@Service
public class RegisterServices {
    @Autowired
    private RegisterRepo repo;

    public Register saveDetails(Register register) {
        register.setToken(generateToken());
        return repo.save(register);
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    public String authenticate(String username, String password) {
        Optional<Register> optionalRegister = repo.findByUsernameAndPassword(username, password);
        if (optionalRegister.isPresent()) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
