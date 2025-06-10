package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
    List<Receta> findByPaciente_Rut(String rut); // Nota la sintaxis: 'paciente_' seguido del atributo 'Rut'
}
