package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface CitaService {
    List<Cita> findAll();

    void deleteById(Long id);

    void save(Cita cita);

    Cita getById(Long id);

    List<Cita> findcitasPendientes(Long idUser);

    void atendidoPorMedico(Long id);

    void llegadaPaciente(Long id);

    Cita crearCitaDisponible(Date fecha, LocalTime hora, String sucursal, Medico medico);

    List<Cita> findDisponiblesByMedicoId(Long idMedico);

    void asignarPacienteACita(Long idCita, Long idPaciente);
}
