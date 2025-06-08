package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Cita;

import java.util.List;

public interface CitaService {
    List<Cita> findAll();

    void deleteById(Long id);

    void save(Cita cita);

    Cita getById(Long id);
}
