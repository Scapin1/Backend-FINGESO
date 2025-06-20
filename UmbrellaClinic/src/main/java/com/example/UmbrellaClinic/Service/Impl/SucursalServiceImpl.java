package com.example.UmbrellaClinic.Service.Impl;


import com.example.UmbrellaClinic.Entity.Sucursal;
import com.example.UmbrellaClinic.Repository.SucursalRepository;
import com.example.UmbrellaClinic.Service.interfaces.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl implements SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public void save(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

    @Override
    public Sucursal getById(Long id) {
        return sucursalRepository.findById(id).orElse(null);
    }
}
