package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Repository.MedicamentoRepository;
import com.example.UmbrellaClinic.Service.interfaces.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> findAll() {
        return medicamentoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        medicamentoRepository.deleteById(id);
    }

    @Override
    public void save(Medicamento medicamento) {
        medicamentoRepository.save(medicamento);
    }

    @Override
    public Medicamento getById(Long id) {
        return medicamentoRepository.findById(id).orElse(null);
    }
}
