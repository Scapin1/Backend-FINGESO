package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> findAll();

    void deleteById(Long id);

    void save(Paciente paciente);

    Paciente getById(Long id);

    boolean autorizacionLoginPaciente(String correo, String password);

    int getIdByRut(String rut);
}
