package com.example.UmbrellaClinic.Service.interfaces.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;

import java.util.List;

public interface QuimicoFarmaceuticoService{

    List<QuimicoFarmaceutico> findAll();

    void deleteById(Long id);

    void save(QuimicoFarmaceutico quimicoFarmaceutico);

    QuimicoFarmaceutico getById(Long id);

    boolean autorizacionLoginQuimicoFarmaceutico(String correo, String password);
}
