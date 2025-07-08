package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
    List<Receta> findByPaciente_Rut(String rut);
}
