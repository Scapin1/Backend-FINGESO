package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.MedicoRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService, LoginService {
    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public Medico getById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public UserType getUserType() {
        return UserType.MEDICO;
    }

    @Override
    public boolean authenticate(String correo, String password) {
        return medicoRepository.findByCorreo(correo)
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }

}
