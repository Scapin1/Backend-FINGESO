package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
