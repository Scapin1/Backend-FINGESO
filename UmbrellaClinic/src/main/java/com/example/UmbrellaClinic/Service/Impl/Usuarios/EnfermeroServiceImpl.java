package com.example.UmbrellaClinic.Service.Impl.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.EnfermeroRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.EnfermeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class EnfermeroServiceImpl implements EnfermeroService {
    @Autowired
    private EnfermeroRepository enfermeroRepository;

    @Override
    public List<Enfermero> findAll() {
        return enfermeroRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        enfermeroRepository.deleteById(id);
    }

    @Override
    public void save(Enfermero enfermero) {
        enfermeroRepository.save(enfermero);
    }

    @Override
    public Enfermero getById(Long id) {
        return enfermeroRepository.findById(id).orElse(null);
    }

    @Override
    public boolean autorizacionLoginEnfermero(String correo, String password) {
        Optional<Enfermero> optEnfermero = enfermeroRepository.findByCorreo(correo);
        if (optEnfermero.isPresent()) {
            Enfermero usuario = optEnfermero.get();
            return usuario.getPassword().equals(password);
        }
        return false; // Usuario no encontrado o contraseña incorrecta
    }

}
