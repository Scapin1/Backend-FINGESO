package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.SoporteTecnico;
import com.example.UmbrellaClinic.Repository.Usuarios.SoporteTecnicoRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.SoporteTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoporteTecnicoServiceImpl implements SoporteTecnicoService {
    @Autowired
    private SoporteTecnicoRepository soporteTecnicoRepository;

    @Override
    public List<SoporteTecnico> findAll() {
        return soporteTecnicoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        soporteTecnicoRepository.deleteById(id);
    }

    @Override
    public void save(SoporteTecnico soporteTecnico) {
        soporteTecnicoRepository.save(soporteTecnico);
    }

    @Override
    public SoporteTecnico getById(Long id) {
        return soporteTecnicoRepository.findById(id).orElse(null);
    }



}
