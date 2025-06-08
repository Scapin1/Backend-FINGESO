package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Examen;

import java.util.List;

public interface ExamenService {
    List<Examen> findAll();

    void deleteById(Long id);

    void save(Examen examen);

    Examen getById(Long id);
}
