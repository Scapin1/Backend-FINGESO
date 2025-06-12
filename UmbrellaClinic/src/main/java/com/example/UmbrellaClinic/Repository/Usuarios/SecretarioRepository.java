package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Secretario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SecretarioRepository extends JpaRepository<Secretario, Long> {
    Optional<Secretario> findByCorreo(String correo);
}
