package com.example.UmbrellaClinic.DTOs;

import lombok.Getter;


@Getter
public class    AuthResponse {

    private UserType userType;

    public AuthResponse(UserType userType) {
        this.userType = userType;
    }

    public void setUserType(UserType userType){
        this.userType = userType;
    }
}
