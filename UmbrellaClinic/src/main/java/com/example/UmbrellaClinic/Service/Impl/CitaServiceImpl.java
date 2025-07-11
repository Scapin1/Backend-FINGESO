package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.CitaRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.interfaces.CitaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Cita cita = citaRepository.getById(id);
        if(LocalDate.now().equals(LocalDate.ofInstant(cita.getFechaCita().toInstant(), ZoneId.systemDefault()))) {
            if(cita.getHoraCita().minusMinutes(30).isBefore(LocalTime.now())){
                throw new RuntimeException("No se puede eliminar una cita con menos de 30 minutos de antelación.");
            }else{
                cita.setEliminada(true); // Cambia el estado de la cita a eliminada
                cita.setDisponible(true);
                citaRepository.save(cita); // Guarda la cita actualizada
            }
        }else{
            cita.setEliminada(true); // Cambia el estado de la cita a eliminada
            cita.setDisponible(true);
            citaRepository.save(cita); // Guarda la cita actualizada
        }
    }

    @Override
    public void save(Cita cita) {
        Paciente paciente = cita.getPaciente();
        Medico medico = cita.getMedico();
        if(medico.getRut().equals(paciente.getRut())) {
            throw new IllegalArgumentException("Un médico no puede agendarse a sí mismo.");
        }
        cita.setDisponible(false);
        citaRepository.save(cita);
    }

    @Override
    public Cita getById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }
    @Override
    public List<Cita> findcitasPendientes(Long userId) {
        return citaRepository.findCitasPendientesByUserId(userId);
    }

    @Override
    public void atendidoPorMedico(Long id){
        Cita cita = citaRepository.getById(id);
        cita.setAgendaMedico(false);
        citaRepository.save(cita);
    }

    @Override
    public void llegadaPaciente(Long id){
        Cita cita = citaRepository.getById(id);
        cita.setAgendaPaciente(false);
        citaRepository.save(cita);
    }

    public Cita crearCitaDisponible(Date fecha, LocalTime hora, String sucursal, Medico medico) {
        Cita cita = new Cita();
        cita.setFechaCita(fecha);
        cita.setHoraCita(hora);
        cita.setSucursal(sucursal);
        cita.setMedico(medico);
        cita.setDisponible(true);
        cita.setEliminada(false);
        cita.setAgendaMedico(true);
        cita.setAgendaPaciente(true);
        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> findDisponiblesByMedicoId(Long idMedico) {
        return citaRepository.findDisponiblesByMedicoId(idMedico);
    }
    @Transactional
    public void asignarPacienteACita(Long idCita, Long idPaciente) {
        Cita cita = citaRepository.getById(idCita);
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
