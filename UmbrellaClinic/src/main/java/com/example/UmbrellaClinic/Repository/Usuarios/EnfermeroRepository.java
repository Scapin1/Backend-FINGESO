package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EnfermeroRepository extends JpaRepository<Enfermero, Long> {
    Optional<Enfermero> findByCorreo(String correo);
}
