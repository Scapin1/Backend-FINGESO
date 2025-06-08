package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
import com.example.UmbrellaClinic.Repository.Usuarios.QuimicoFarmaceuticoRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.QuimicoFarmaceuticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuimicoFarmaceuticoServiceImpl implements QuimicoFarmaceuticoService {
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

}
