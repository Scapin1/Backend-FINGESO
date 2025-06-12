package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
}
