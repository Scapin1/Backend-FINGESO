package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Tratamiento;

import java.util.List;

public interface TratamientoService {
    List<Tratamiento> findAll();

    void deleteById(Long id);

    void save(Tratamiento tratamiento);

    Tratamiento getById(Long id);
}
