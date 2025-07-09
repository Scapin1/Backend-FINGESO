package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Sucursal;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.SucursalRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.MedicoRepository;
import com.example.UmbrellaClinic.Service.interfaces.LoginService;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import com.example.UmbrellaClinic.DTOs.UserType;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService, LoginService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public void save(Medico medico) {
        medico.setCorreo(medico.getCorreo().toLowerCase());

        // ⚠️ Asegúrate de cargar las sucursales desde la base de datos
        if (medico.getSucursales() != null) {
            List<Sucursal> sucursalesAdjuntas = new ArrayList<>();
            for (Sucursal s : medico.getSucursales()) {
                Sucursal sucursalReal = sucursalRepository.findById(s.getIdSucursal())
                        .orElseThrow(() -> new RuntimeException("Sucursal no encontrada con id " + s.getIdSucursal()));
                sucursalesAdjuntas.add(sucursalReal);
            }
            medico.setSucursales(sucursalesAdjuntas);
        }

        medicoRepository.save(medico);
    }

    @Override
    public Medico getById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public UserType getUserType() {
        return UserType.MEDICO;
    }
    @Override
    public long getUserId(String correo) {
        return medicoRepository.findByCorreo(correo).orElse(null).getId();
    }

    @Override
    public boolean authenticate(String correo, String password) {
        return medicoRepository.findByCorreo(correo)
                .map(p -> p.getPassword().equals(password))
                .orElse(false);
    }

    public Medico findById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

}
