package com.example.demo.service;

import com.example.demo.entity.Login;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public Login checkUsername(String username) {

        Optional<Login> loginDetails = loginRepository.findByUsername(username);
        if (!loginDetails.isPresent()) throw new UserNotFoundException(username);

        return loginDetails.get();
    }
}
