package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.ExamenRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.EnfermeroRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.interfaces.ExamenService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Override
    public List<Examen> findAll() {
        return examenRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        examenRepository.deleteById(id);
    }

    @Transactional
    public Examen createExamen (Examen examen) {
        // Se busca al paciente asociado al examen
        Paciente paciente = pacienteRepository.findById(examen.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // Se obtiene el historial medico del paciente
        HistorialMedico historial = paciente.getHistorialMedico();

        // Asignar historial y paciente al examen
        examen.setHistorialMedico(historial);
        examen.setPaciente(paciente);

        // Obtener enfermero y asignar examen a enfermero
        if (examen.getEnfermero() != null && examen.getEnfermero().getId() != null) {
            Enfermero enfermero = enfermeroRepository.findById(examen.getEnfermero().getId())
                    .orElseThrow(() -> new RuntimeException("Enfermero no encontrado"));
            examen.setEnfermero(enfermero);
        } else {
            throw new RuntimeException("Debe asignar un enfermero válido al examen");
        }

        // Guardar examen en la BD
        Examen examenGuardado = examenRepository.save(examen);

        // Agregar examen a historial del paciente y guardar paciente
        historial.getExamenes().add(examenGuardado);
        pacienteRepository.save(paciente);

        // Obtener el enfermero del examen guardado y agregar examen a la lista de exámenes del enfermero y guardar enfermero
        Enfermero enfermero = examenGuardado.getEnfermero();
        enfermero.getExamenList().add(examenGuardado);
        enfermeroRepository.save(enfermero);

        //Retornar el examen guardado
        return examenGuardado;
    }


    @Override
    public void save(Examen examen) {
        examenRepository.save(examen);
    }

    @Override
    public Examen getById(Long id) {
        return examenRepository.findById(id).orElse(null);
    }

}
