package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
}
