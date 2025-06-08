package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Reporte;

import java.util.List;

public interface ReporteService {
    List<Reporte> findAll();

    void deleteById(Long id);

    void save(Reporte reporte);

    Reporte getById(Long id);
}
