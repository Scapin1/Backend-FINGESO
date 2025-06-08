package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Medico;

import java.util.List;

public interface MedicoService{

    List<Medico> findAll();

    void deleteById(Long id);

    void save(Medico medico);

    Medico getById(Long id);
}
