package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    Medicamento findByNombreComercial(String nombreComercial);

}
