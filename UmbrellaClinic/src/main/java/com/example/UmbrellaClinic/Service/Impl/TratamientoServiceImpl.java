package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Tratamiento;
import com.example.UmbrellaClinic.Repository.TratamientoRepository;
import com.example.UmbrellaClinic.Service.interfaces.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamientoServiceImpl implements TratamientoService {
    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public List<Tratamiento> findAll() {
        return tratamientoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        tratamientoRepository.deleteById(id);
    }

    @Override
    public void save(Tratamiento tratamiento) {
        tratamientoRepository.save(tratamiento);
    }

    @Override
    public Tratamiento getById(Long id) {
        return tratamientoRepository.findById(id).orElse(null);
    }
}
