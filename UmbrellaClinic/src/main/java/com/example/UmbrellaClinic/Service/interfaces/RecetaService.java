package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Receta;

import java.util.List;

public interface RecetaService {
    List<Receta> findAll();

    void deleteById(Long id);

    void save(Receta receta);

    Receta getById(Long id);
}
