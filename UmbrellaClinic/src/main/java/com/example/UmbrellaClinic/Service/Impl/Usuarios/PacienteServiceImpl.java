package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PacienteServiceImpl implements PacienteService {
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
        pacienteRepository.save(paciente);
    }

    @Override
    public Paciente getById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

}
