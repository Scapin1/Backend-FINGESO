package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Entity.Usuarios.Usuario;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
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
        pacienteRepository.save(paciente);
    }

    @Override
    public Paciente getById(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public boolean autorizacionLoginPaciente(String correo, String password) {
        Optional<Paciente> optPaciente = pacienteRepository.findByCorreo(correo);
        if (optPaciente.isPresent()) {
            Paciente usuario = optPaciente.get();
            return usuario.getPassword().equals(password);
        }
        return false; // Usuario no encontrado o contraseña incorrecta
    }

    public UserType getUserType() {
        return UserType.PACIENTE;
    }

    public boolean authenticate(String correo, String password) {
        Optional<Paciente> optPaciente = pacienteRepository.findByCorreo(correo);
        return optPaciente
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }
}
