package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuimicoFarmaceuticoRepository extends JpaRepository<QuimicoFarmaceutico, Long> {
    Optional<QuimicoFarmaceutico> findByCorreo(String correo);
}
