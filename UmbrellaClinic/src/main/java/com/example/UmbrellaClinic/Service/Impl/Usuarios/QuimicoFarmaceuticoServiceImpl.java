package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
import com.example.UmbrellaClinic.Repository.Usuarios.QuimicoFarmaceuticoRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.QuimicoFarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;

@Service
public class QuimicoFarmaceuticoServiceImpl implements QuimicoFarmaceuticoService, LoginService {
    @Autowired
    private QuimicoFarmaceuticoRepository quimicoFarmaceuticoRepository;


    @Override
    public List<QuimicoFarmaceutico> findAll() {
        return quimicoFarmaceuticoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        quimicoFarmaceuticoRepository.deleteById(id);
    }

    @Override
    public void save(QuimicoFarmaceutico quimicoFarmaceutico) {
        quimicoFarmaceuticoRepository.save(quimicoFarmaceutico);
    }

    @Override
    public QuimicoFarmaceutico getById(Long id) {
        return quimicoFarmaceuticoRepository.findById(id).orElse(null);
    }
    @Override
    public boolean autorizacionLoginQuimicoFarmaceutico(String correo, String password) {
        Optional<QuimicoFarmaceutico> optQuimicoFarmaceutico = quimicoFarmaceuticoRepository.findByCorreo(correo);
        if (optQuimicoFarmaceutico.isPresent()) {
            QuimicoFarmaceutico usuario = optQuimicoFarmaceutico.get();
            return usuario.getPassword().equals(password);
        }
        return false; // Usuario no encontrado o contraseña incorrecta
    }

    public UserType getUserType() {
        return UserType.QUIMICO_FARMACEUTICO;
    }
    public boolean authenticate(String correo, String password) {
        Optional<QuimicoFarmaceutico> optQuimicoFarmaceutico = quimicoFarmaceuticoRepository.findByCorreo(correo);
        return optQuimicoFarmaceutico
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }
}
