package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.CitaRepository;
import com.example.UmbrellaClinic.Service.interfaces.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;
    @Override
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        Cita cita = citaRepository.getById(id);
        System.out.println(cita.getFechaCita());
        System.out.println(LocalDate.now());
        if(LocalDate.now().equals(LocalDate.ofInstant(cita.getFechaCita().toInstant(), ZoneId.systemDefault()))) {
            if(cita.getHoraCita().minusMinutes(30).isBefore(LocalTime.now())){
                throw new RuntimeException("No se puede eliminar una cita con menos de 30 minutos de antelación.");
            }else{
                cita.setEliminada(true); // Cambia el estado de la cita a eliminada
                citaRepository.save(cita); // Guarda la cita actualizada
            }
        }else{
            cita.setEliminada(true); // Cambia el estado de la cita a eliminada
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

}
