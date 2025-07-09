package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.CitaExamen;
import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.CitaExamenRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.interfaces.CitaExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CitaExamenServiceImpl implements CitaExamenService {

    @Autowired
    private CitaExamenRepository citaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<CitaExamen> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        CitaExamen cita = citaRepository.getById(id);
        System.out.println(cita.getFechaCita());
        System.out.println(LocalDate.now());
        if (LocalDate.now().equals(LocalDate.ofInstant(cita.getFechaCita().toInstant(), ZoneId.systemDefault()))) {
            if (cita.getHoraCita().minusMinutes(30).isBefore(LocalTime.now())) {
                throw new RuntimeException("No se puede eliminar una cita con menos de 30 minutos de antelación.");
            } else {
                cita.setEliminada(true);
                cita.setDisponible(true);
                citaRepository.save(cita);
            }
        } else {
            cita.setEliminada(true);
            cita.setDisponible(true);
            citaRepository.save(cita);
        }
    }

    @Override
    public void save(CitaExamen cita) {
        Paciente paciente = cita.getPaciente();
        Enfermero enfermero = cita.getEnfermero();
        if (enfermero.getRut().equals(paciente.getRut())) {
            throw new IllegalArgumentException("Un enfermero no puede agendarse a sí mismo.");
        }
        citaRepository.save(cita);
    }

    @Override
    public CitaExamen getById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public List<CitaExamen> findCitasPendientes(Long userId) {
        return citaRepository.findCitasPendientesByUserId(userId);
    }

    @Override
    public void atendidoPorEnfermero(Long id) {
        CitaExamen cita = citaRepository.getById(id);
        cita.setAgendaEnfermero(false);
        citaRepository.save(cita);
    }

    @Override
    public void llegadaPaciente(Long id) {
        CitaExamen cita = citaRepository.getById(id);
        cita.setAgendaPaciente(false);
        citaRepository.save(cita);
    }

    @Override
    public CitaExamen crearCitaDisponible(Date fecha, LocalTime hora, String sucursal, Enfermero enfermero) {
        CitaExamen cita = new CitaExamen();
        cita.setFechaCita(fecha);
        cita.setHoraCita(hora);
        cita.setSucursal(sucursal);
        cita.setEnfermero(enfermero);
        cita.setDisponible(true);
        cita.setEliminada(false);
        cita.setAgendaEnfermero(true);
        cita.setAgendaPaciente(true);
        return citaRepository.save(cita);
    }

    @Override
    public List<CitaExamen> findDisponiblesByEnfermeroId(Long idEnfermero) {
        return citaRepository.findDisponiblesByEnfermeroId(idEnfermero);
    }

    @Override
    public void asignarPacienteACita(Long idCita, Long idPaciente) {
        CitaExamen cita = getById(idCita);
        if (cita == null) {
            throw new RuntimeException("Cita no encontrada.");
        }

        if (!cita.getDisponible()) {
            throw new RuntimeException("La cita ya está reservada.");
        }

        Paciente paciente = pacienteRepository.findById(idPaciente)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        cita.setPaciente(paciente);
        cita.setDisponible(false);
        citaRepository.save(cita);
    }
}

