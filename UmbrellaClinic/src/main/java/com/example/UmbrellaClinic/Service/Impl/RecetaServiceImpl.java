package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Repository.RecetaRepository;
import com.example.UmbrellaClinic.Service.interfaces.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService {
    @Autowired
    private RecetaRepository recetaRepository;

    @Override
    public List<Receta> findAll() {
        return recetaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        recetaRepository.deleteById(id);
    }

    @Override
    public void save(Receta receta) {
        return recetaRepository.findByPaciente_Rut(rut);
    }

    @Override
    public Receta getById(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }
}
