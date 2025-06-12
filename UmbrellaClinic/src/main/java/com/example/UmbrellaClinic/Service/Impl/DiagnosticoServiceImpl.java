package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Diagnostico;
import com.example.UmbrellaClinic.Repository.DiagnosticoRepository;
import com.example.UmbrellaClinic.Service.interfaces.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {
    @Autowired
    private DiagnosticoRepository diagnosticoRepository;

    @Override
    public List<Diagnostico> findAll() {
        return diagnosticoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        diagnosticoRepository.deleteById(id);
    }

    @Override
    public void save(Diagnostico diagnostico) {
        diagnosticoRepository.save(diagnostico);
    }

    @Override
    public Diagnostico getById(Long id) {
        return diagnosticoRepository.findById(id).orElse(null);
    }


}
