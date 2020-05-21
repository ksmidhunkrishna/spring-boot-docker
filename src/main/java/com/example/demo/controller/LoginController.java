package com.example.demo.controller;

import com.example.demo.entity.Login;
import com.example.demo.entity.request.UserDetails;
import com.example.demo.service.LoginService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;


    @PostMapping("/user")
    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    public Login getUserDetails(@Validated @RequestBody UserDetails userDetails) {
        System.out.println("user" + userDetails.getUsername());
        return loginService.checkUsername(userDetails.getUsername());
    }
}
