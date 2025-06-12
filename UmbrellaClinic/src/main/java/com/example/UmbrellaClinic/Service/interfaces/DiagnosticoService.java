package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Diagnostico;

import java.util.List;

public interface DiagnosticoService {
    List<Diagnostico> findAll();

    void deleteById(Long id);

    void save(Diagnostico diagnostico);

    Diagnostico getById(Long id);
}
