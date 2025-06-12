package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.SoporteTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SoporteTecnicoRepository extends JpaRepository<SoporteTecnico, Long> {
    Optional<SoporteTecnico> findByCorreo(String correo);
}
