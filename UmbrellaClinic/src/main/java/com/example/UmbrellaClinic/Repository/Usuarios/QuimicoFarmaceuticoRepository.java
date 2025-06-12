package com.example.UmbrellaClinic.Repository.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QuimicoFarmaceuticoRepository extends JpaRepository<QuimicoFarmaceutico, Long> {
    Optional<QuimicoFarmaceutico> findByCorreo(String correo);
}
