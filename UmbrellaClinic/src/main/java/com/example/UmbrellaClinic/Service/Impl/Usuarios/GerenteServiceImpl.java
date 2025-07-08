package com.example.UmbrellaClinic.Service.Impl.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Gerente;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.GerenteRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;

@Service
public class GerenteServiceImpl implements GerenteService, LoginService {
    @Autowired
    private GerenteRepository gerenteRepository;

    @Override
    public List<Gerente> findAll() {
        return gerenteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        gerenteRepository.deleteById(id);
    }

    @Override
    public void save(Gerente gerente) {
        gerente.setCorreo(gerente.getCorreo().toLowerCase());
        gerenteRepository.save(gerente);
    }

    @Override
    public Gerente getById(Long id) {
        return gerenteRepository.getById(id);
    }

    @Override
    public UserType getUserType() {
        return UserType.GERENTE;
    }

    @Override
    public long getUserId(String correo) {
        return gerenteRepository.findByCorreo(correo).orElse(null).getId();
    }

    @Override
    public boolean authenticate(String correo, String password) {
        return gerenteRepository.findByCorreo(correo)
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }

}
