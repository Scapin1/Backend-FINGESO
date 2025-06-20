package com.example.UmbrellaClinic.Service.interfaces;

import com.example.UmbrellaClinic.Entity.Sucursal;

import java.util.List;

public interface SucursalService {
    List<Sucursal> findAll();

    void deleteById(Long id);

    void save(Sucursal sucursal);

    Sucursal getById(Long id);
}
