package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Entity.Usuarios.Secretario;
import com.example.UmbrellaClinic.Repository.Usuarios.SecretarioRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.SecretarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;

@Service
public class SecretarioServiceImpl implements SecretarioService, LoginService {
    @Autowired
    private SecretarioRepository secretarioRepository;

    @Override
    public List<Secretario> findAll() {
        return secretarioRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        secretarioRepository.deleteById(id);
    }

    @Override
    public void save(Secretario secretario) {
        secretario.setCorreo(secretario.getCorreo().toLowerCase());
        secretarioRepository.save(secretario);
    }

    @Override
    public Secretario getById(Long id) {
        return secretarioRepository.findById(id).orElse(null);
    }


    @Override
    public UserType getUserType() {
        return UserType.SECRETARIO;
    }
    @Override
    public long getUserId(String correo) {
        return secretarioRepository.findByCorreo(correo).orElse(null).getId();
    }

    @Override
    public boolean authenticate(String correo, String password) {
        return secretarioRepository.findByCorreo(correo)
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }


}
