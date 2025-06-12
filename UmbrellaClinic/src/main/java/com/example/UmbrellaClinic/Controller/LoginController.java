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

    private AuthService authService;

    @Autowired
    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        try {
            AuthResponse resp = authService.login(req);
            return ResponseEntity.ok(resp);
        } catch (IllegalArgumentException ex) {
            // Password inválida o correo no encontrado
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
