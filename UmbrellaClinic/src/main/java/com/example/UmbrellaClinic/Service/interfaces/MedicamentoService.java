package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Medicamento;

import java.util.List;

public interface MedicamentoService {
    List<Medicamento> findAll();

    void deleteById(Long id);

    void save(Medicamento medicamento);

    Medicamento getById(Long id);

    Medicamento updateStocks(String nombreMed, int newStockReal, int newStockReceta);
}
