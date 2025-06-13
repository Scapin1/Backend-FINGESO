package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Entity.Usuarios.SoporteTecnico;
import com.example.UmbrellaClinic.Repository.Usuarios.SoporteTecnicoRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.SoporteTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;

@Service
public class SoporteTecnicoServiceImpl implements SoporteTecnicoService, LoginService {
    @Autowired
    private SoporteTecnicoRepository soporteTecnicoRepository;

    @Override
    public List<SoporteTecnico> findAll() {
        return soporteTecnicoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        soporteTecnicoRepository.deleteById(id);
    }

    @Override
    public void save(SoporteTecnico soporteTecnico) {
        soporteTecnicoRepository.save(soporteTecnico);
    }

    @Override
    public SoporteTecnico getById(Long id) {
        return soporteTecnicoRepository.findById(id).orElse(null);
    }

    @Override
    public UserType getUserType() {
        return UserType.SOPORTE_TECNICO;
    }

    @Override
    public boolean authenticate(String correo, String password) {
        return soporteTecnicoRepository.findByCorreo(correo)
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }

}
