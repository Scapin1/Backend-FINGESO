package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.CitaExamen;
import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface CitaExamenService {

    List<CitaExamen> findAll();

    void deleteById(Long id);

    void save(CitaExamen cita);

    CitaExamen getById(Long id);

    List<CitaExamen> findCitasPendientes(Long idUser);

    void atendidoPorEnfermero(Long id);

    void llegadaPaciente(Long id);

    CitaExamen crearCitaDisponible(Date fecha, LocalTime hora, String sucursal, Enfermero enfermero);

    List<CitaExamen> findDisponiblesByEnfermeroId(Long idEnfermero);

    void asignarPacienteACita(Long idCita, Long idPaciente);
}
