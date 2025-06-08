package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Reporte;
import com.example.UmbrellaClinic.Repository.ReporteRepository;
import com.example.UmbrellaClinic.Service.interfaces.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public List<Reporte> findAll() {
        return reporteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        reporteRepository.deleteById(id);
    }

    @Override
    public void save(Reporte reporte) {
        reporteRepository.save(reporte);
    }

    @Override
    public Reporte getById(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

}
