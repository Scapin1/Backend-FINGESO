package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;

import java.util.List;

public interface EnfermeroService {

    List<Enfermero> findAll();

    void deleteById(Long id);

    void save(Enfermero enfermero);

    Enfermero getById(Long id);

    boolean autorizacionLoginEnfermero(String correo, String password);
}
