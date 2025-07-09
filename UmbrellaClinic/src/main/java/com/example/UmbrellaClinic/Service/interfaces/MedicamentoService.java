package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Medicamento;

import java.util.List;

public interface MedicamentoService {
    List<Medicamento> findAll();

    void deleteById(Long id);

    void save(Medicamento medicamento);

    Medicamento getById(Long id);

    Medicamento getByNombreComercial(String nombreComercial);

    int reservarStock(long idMedicamento, int cantidad);

    void reabastecerMedicamentos(Long id, int cantidad);

    void entregarMedicamentos(Long id, int cantidad);

    void actualizarStock(List<Medicamento> medicamentos, List<Integer> cantidades);
}
