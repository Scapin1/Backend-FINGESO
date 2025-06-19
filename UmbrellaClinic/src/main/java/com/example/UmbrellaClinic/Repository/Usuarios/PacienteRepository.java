package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCorreo(String correo);
    @Query("SELECT p.id FROM Paciente p WHERE p.rut = ?1")
    int findIdByRut(String rut);
    Optional<Paciente> findByRut(String rut);
}
