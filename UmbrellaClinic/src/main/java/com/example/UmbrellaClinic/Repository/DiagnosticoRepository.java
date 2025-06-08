package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
}
