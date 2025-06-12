package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.SoporteTecnico;

import java.util.List;

public interface SoporteTecnicoService{
    List<SoporteTecnico> findAll();

    void deleteById(Long id);

    void save(SoporteTecnico soporteTecnico);

    SoporteTecnico getById(Long id);

    boolean autorizacionLoginSoporteTecnico(String correo, String password);
}
