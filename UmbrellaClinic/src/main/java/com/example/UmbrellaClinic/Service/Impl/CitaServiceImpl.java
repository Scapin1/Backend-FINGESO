package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Repository.CitaRepository;
import com.example.UmbrellaClinic.Service.interfaces.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> findAll() {
        return citaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public void save(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public Cita getById(Long id) {
        return citaRepository.findById(id).orElse(null);
    }


}
