package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Repository.ExamenRepository;
import com.example.UmbrellaClinic.Service.interfaces.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServiceImpl implements ExamenService {
    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public List<Examen> findAll() {
        return examenRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        examenRepository.deleteById(id);
    }

    @Override
    public void save(Examen examen) {
        examenRepository.save(examen);
    }

    @Override
    public Examen getById(Long id) {
        return examenRepository.findById(id).orElse(null);
    }

}
