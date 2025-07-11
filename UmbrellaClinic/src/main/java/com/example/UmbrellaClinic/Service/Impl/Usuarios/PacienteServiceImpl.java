package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;
@Service
public class PacienteServiceImpl implements PacienteService, LoginService {


    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {

        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente save(Paciente paciente) {
        // Si el paciente no tiene un historial médico, se crea uno nuevo
        if (paciente.getHistorialMedico() == null) {
            HistorialMedico historial = new HistorialMedico();
            historial.setPaciente(paciente);  // Aquí se enlaza el idPaciente
            paciente.setHistorialMedico(historial);
        }

        // Se obtiene el historial médico
        HistorialMedico historialMedico = paciente.getHistorialMedico();

        // Relacionar exámenes
        if (paciente.getExamenes() != null) {
            for (Examen examen : paciente.getExamenes()) {
                examen.setPaciente(paciente);
                examen.setHistorialMedico(historialMedico);
            }
            historialMedico.setExamenes(paciente.getExamenes());
        }

        // Relacionar recetas
        if (paciente.getRecetas() != null) {
            for (Receta receta : paciente.getRecetas()) {
                receta.setPaciente(paciente);
                receta.setHistorialMedico(historialMedico);
            }
            historialMedico.setRecetas(paciente.getRecetas());
        }

        //Se guarda el paciente
        paciente.setCorreo(paciente.getCorreo().toLowerCase());
        return pacienteRepository.save(paciente);
    }


    @Override
    public Paciente getById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public int getIdByRut(String rut) {
        return pacienteRepository.findIdByRut(rut);
    }

    @Override
    public UserType getUserType() {
        return UserType.PACIENTE;
    }

    @Override
    public long getUserId(String correo) {
        return pacienteRepository.findByCorreo(correo).orElse(null).getId();
    }

    @Override
    public boolean authenticate(String correo, String password) {
        return pacienteRepository.findByCorreo(correo)
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }
    @Override
    public Paciente getByRut(String rut) {
        return pacienteRepository.findByRut(rut).orElse(null);
    }

    @Override
    public HistorialMedico getHistorialOrdenado(Long idPaciente) {
        // Obtener el paciente por su ID
        Paciente paciente = getById(idPaciente);

        // Verificar si el paciente existe y si tiene historial médico
        if (paciente == null || paciente.getHistorialMedico() == null) {
            return null;
        }

        // Obtener el historial médico del paciente
        HistorialMedico historial = paciente.getHistorialMedico();

        // Se ordenan los examenes segun su fecha
        if (historial.getExamenes() != null) {
            historial.getExamenes().sort((e1, e2) -> e1.getFechaExamen().compareTo(e2.getFechaExamen()));
        }

        // Se ordenan las recetas segun su fecha
        if (historial.getRecetas() != null) {
            historial.getRecetas().sort((r1, r2) -> r1.getFechaEmision().compareTo(r2.getFechaEmision()));
        }

        // Retornar el historial con las listas de receta y examenes ordenadas de manera asc
        return historial;
    }

    @Override
    public void updatePaciente(String nombre, String contraseña, Long id) {
        // Verifica si el paciente existe
        Paciente existingPaciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        // Actualiza los campos necesarios
        existingPaciente.setNombre(nombre);
        existingPaciente.setPassword(contraseña);

        // Guarda el paciente actualizado
        pacienteRepository.save(existingPaciente);
    }
}
