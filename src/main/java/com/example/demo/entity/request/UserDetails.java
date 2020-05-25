package com.example.demo.entity.request;


import javax.validation.constraints.NotNull;

public class UserDetails {

    @NotNull(message = "stringValue has to be present")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
