package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.DTOs.LoginRequest;
import com.example.UmbrellaClinic.DTOs.AuthResponse;
import com.example.UmbrellaClinic.Service.Impl.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/auth")
public class LoginController {

    // inyectar dependencias para conectar con la logica de autenticacion
    private AuthService authService;

    @Autowired
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    // endpoint tipo post para iniciar sesión con email y contraseña
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        try {
            AuthResponse resp = authService.login(req);
            return ResponseEntity.ok(resp);
        } catch (IllegalArgumentException ex) {
            // si la contraseña es inválida o el correo no se encuentra registrado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
