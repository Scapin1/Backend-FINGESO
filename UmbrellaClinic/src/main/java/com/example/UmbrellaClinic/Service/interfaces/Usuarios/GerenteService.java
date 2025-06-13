package com.example.UmbrellaClinic.Service.interfaces.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Gerente;

import java.util.List;

public interface GerenteService {

    List<Gerente> findAll();

    void deleteById(Long id);

    void save(Gerente gerente);

    Gerente getById(Long id);

}
