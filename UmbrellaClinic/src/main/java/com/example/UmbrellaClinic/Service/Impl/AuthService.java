package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.DTOs.LoginRequest;
import com.example.UmbrellaClinic.DTOs.AuthResponse;
import com.example.UmbrellaClinic.DTOs.UserType;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.UsuarioService;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class AuthService {

    private final Map<UserType, LoginService> loginMap = new EnumMap<>(UserType.class);
    private final UsuarioService usuarioService;

    public AuthService(List<LoginService> loginServices, UsuarioService usuarioService) {
        // Indexa cada LoginService por su UserType
        loginServices.forEach(svc ->
                loginMap.put(svc.getUserType(), svc)
        );
        this.usuarioService = usuarioService;
    }

    public AuthResponse login(LoginRequest request) {
        // 1) Determinar si existe el correo y de qué tipo
        int code = usuarioService.verificarTipoUsuario(request.getCorreo());
        if (code == 0) {
            throw new IllegalArgumentException("Correo invalido");
        }

        UserType type = UserType.fromCode(code);
        LoginService svc = loginMap.get(type);

        // 2) Verificar contraseña
        if (!svc.authenticate(request.getCorreo(), request.getPassword())) {
            throw new IllegalArgumentException("Password incorrecta");
        }

        // 3) Devolver tipo de usuario
        return new AuthResponse(type);
    }

}
