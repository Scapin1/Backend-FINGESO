package com.example.UmbrellaClinic.Service.interfaces;
import com.example.UmbrellaClinic.DTOs.UserType;

public interface LoginService {

    boolean authenticate(String correo, String password);


    UserType getUserType();
}
