package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.*;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public interface UsuarioService {
    //1–7 según repositorio donde exista el correo, 0 si no existe.
    int verificarTipoUsuario(String correo);

}
