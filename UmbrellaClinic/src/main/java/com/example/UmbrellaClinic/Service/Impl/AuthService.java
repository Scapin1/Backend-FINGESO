package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.DTOs.LoginRequest;
import com.example.UmbrellaClinic.DTOs.AuthResponse;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AuthService {

    private final List<LoginService> loginServices;

    @Autowired
    public AuthService(List<LoginService> loginServices) {
        this.loginServices = loginServices;
    }
    public AuthResponse login(LoginRequest request) {
        return loginServices.stream().filter(svc -> svc.authenticate(request.getCorreo(), request.getPassword())).findFirst().map(svc -> new AuthResponse(svc.getUserType()))
                .orElseThrow(() -> new IllegalArgumentException("Correo o contraseña inválidos"));
    }
}
