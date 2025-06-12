package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.DTOs.LoginRequest;
import com.example.UmbrellaClinic.DTOs.AuthResponse;
import com.example.UmbrellaClinic.DTOs.UserType;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.UsuarioService;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AuthService {


    private final Map<UserType, LoginService> loginMap;
    private final UsuarioService usuarioService;

    // Spring ve SOLO este constructor, y NO hay otro vacío.
    @Autowired  // opcional si solo tienes un constructor público
    public AuthService(List<LoginService> loginServices, UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

        // build de manera segura el EnumMap
        //this.loginMap = loginServices.stream().peek(svc -> System.out.println("Registrando loginService para: " + svc.getUserType())).collect(Collectors.toMap(LoginService::getUserType, svc -> svc, (a,b) -> a, () -> new EnumMap<>(UserType.class)));
        this.loginMap = loginServices.stream().collect(Collectors.toMap(LoginService::getUserType, svc -> svc, (existing, replacement) -> existing, () -> new EnumMap<>(UserType.class)));
        // opcional: validar que esté completo
        for (UserType t : UserType.values()) {
            if (!loginMap.containsKey(t)) {
                System.err.println("⚠️ No hay LoginService para UserType=" + t);
            }
        }
    }

    public AuthResponse login(LoginRequest request) {
        int code = usuarioService.verificarTipoUsuario(request.getCorreo());
        if (code == 0) {
            throw new IllegalArgumentException("Correo inválido");
        }

        UserType type = UserType.fromCode(code);
        LoginService svc = loginMap.get(type);
        if (svc == null) {
            // esto ya no debería ocurrir, pero por si acaso:
            throw new IllegalStateException("No LoginService definido para tipo " + type);
        }

        if (!svc.authenticate(request.getCorreo(), request.getPassword())) {
            throw new IllegalArgumentException("Password incorrecta");
        }

        return new AuthResponse(type);
    }
}
