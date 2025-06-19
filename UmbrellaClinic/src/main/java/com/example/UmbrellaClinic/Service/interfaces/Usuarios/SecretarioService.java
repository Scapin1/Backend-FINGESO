package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Secretario;

import java.util.List;

public interface SecretarioService {

    List<Secretario> findAll();

    void deleteById(Long id);

    void save(Secretario secretario);

    Secretario getById(Long id);

}
