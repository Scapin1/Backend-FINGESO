package com.example.UmbrellaClinic.Service.Impl.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.EnfermeroRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.EnfermeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;

@Service
public class EnfermeroServiceImpl implements EnfermeroService, LoginService {
    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Override
    public List<Enfermero> findAll() {
        return enfermeroRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        enfermeroRepository.deleteById(id);
    }

    @Override
    public void save(Enfermero enfermero) {
        enfermero.setCorreo(enfermero.getCorreo().toLowerCase());
        enfermeroRepository.save(enfermero);
    }

    @Override
    public Enfermero getById(Long id) {
        return enfermeroRepository.findById(id).orElse(null);
    }

    @Override
    public UserType getUserType() {
        return UserType.ENFERMERO;
    }

    @Override
    public long getUserId(String correo) {
        return enfermeroRepository.findByCorreo(correo).orElse(null).getId();
    }

    @Override
    public boolean authenticate(String correo, String password) {
        return enfermeroRepository.findByCorreo(correo)
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }

}
