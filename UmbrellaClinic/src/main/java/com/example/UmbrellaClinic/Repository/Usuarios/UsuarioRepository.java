package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo);
}
