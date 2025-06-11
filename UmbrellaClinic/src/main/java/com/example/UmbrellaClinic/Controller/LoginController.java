package com.example.UmbrellaClinic.Controller;
import com.example.UmbrellaClinic.DTOs.LoginRequest;
import com.example.UmbrellaClinic.DTOs.AuthResponse;
import com.example.UmbrellaClinic.Service.Impl.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        AuthResponse resp = authService.login(req);
        return ResponseEntity.ok(resp);
    }
}
