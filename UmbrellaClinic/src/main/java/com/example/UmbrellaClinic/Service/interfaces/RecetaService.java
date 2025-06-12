package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Receta;

import java.util.List;

public interface RecetaService {
    List<Receta> findAll();

    void deleteById(Long id);
    Receta save(Receta receta);
    List<Receta> findByPacienteRut(String rut); // Nuevo nombre para el método

    Receta getById(Long id);
}
