package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.*;


public interface UsuarioService {
    //1–7 según repositorio donde exista el correo, 0 si no existe.
    Integer verificarTipoUsuario(String correo);

}
