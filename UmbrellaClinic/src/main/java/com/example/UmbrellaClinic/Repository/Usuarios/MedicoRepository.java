package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findByCorreo(String correo);
}
