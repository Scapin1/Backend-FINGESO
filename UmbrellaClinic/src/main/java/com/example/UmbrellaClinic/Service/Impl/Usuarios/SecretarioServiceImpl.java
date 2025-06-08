package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Secretario;
import com.example.UmbrellaClinic.Repository.Usuarios.SecretarioRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.SecretarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretarioServiceImpl implements SecretarioService {
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
        secretarioRepository.save(secretario);
    }

    @Override
    public Secretario getById(Long id) {
        return secretarioRepository.findById(id).orElse(null);
    }
}
