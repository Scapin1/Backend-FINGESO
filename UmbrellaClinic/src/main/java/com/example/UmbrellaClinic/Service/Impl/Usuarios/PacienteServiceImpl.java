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
    public void save(Paciente paciente) {
        // Si no tiene historial médico, se crea
        if (paciente.getHistorialMedico() == null) {
            HistorialMedico historial = new HistorialMedico();
            historial.setPaciente(paciente);  // Aquí se enlaza el idPaciente
            paciente.setHistorialMedico(historial);
        }

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

        pacienteRepository.save(paciente); // guarda paciente y todo en cascada
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
        Paciente paciente = getById(idPaciente);

        if (paciente == null || paciente.getHistorialMedico() == null) {
            return null;
        }

        HistorialMedico historial = paciente.getHistorialMedico();

        // Ordenar exámenes por fechaExamen
        if (historial.getExamenes() != null) {
            historial.getExamenes().sort((e1, e2) -> e1.getFechaExamen().compareTo(e2.getFechaExamen()));
        }

        // Ordenar recetas por fechaEmision
        if (historial.getRecetas() != null) {
            historial.getRecetas().sort((r1, r2) -> r1.getFechaEmision().compareTo(r2.getFechaEmision()));
        }

        return historial;
    }
}
