package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.DTOs.LoginRequest;
import com.example.UmbrellaClinic.DTOs.AuthResponse;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AuthService {

    private final List<com.example.UmbrellaClinic.Service.interfaces.LoginService> loginServices;

    @Autowired
    public AuthService(List<com.example.UmbrellaClinic.Service.interfaces.LoginService> loginServices) {
        this.loginServices = loginServices;
    }
    public AuthResponse login(LoginRequest request) {
        String correo = request.getCorreo().trim().toLowerCase();
        String password = request.getPassword();
        return loginServices.stream().filter(svc -> svc.authenticate(correo, password)).findFirst().map(svc -> new AuthResponse(svc.getUserType(),svc.getUserId(correo)))
                .orElseThrow(() -> new IllegalArgumentException("Correo o contraseña inválidos"));
    }
}
