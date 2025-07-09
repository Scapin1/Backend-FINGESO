package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> findAll();

    void deleteById(Long id);

    Paciente save(Paciente paciente);

    Paciente getById(Long id);

    int getIdByRut(String rut);

    Paciente getByRut(String rut);

    HistorialMedico getHistorialOrdenado(Long idPaciente);

    void updatePaciente(String nombre, String contraseña, Long id);
}
