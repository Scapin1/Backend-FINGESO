package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}
