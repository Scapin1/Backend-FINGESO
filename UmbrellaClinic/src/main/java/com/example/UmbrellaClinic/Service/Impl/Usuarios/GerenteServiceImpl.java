package com.example.UmbrellaClinic.Service.Impl.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Gerente;
import com.example.UmbrellaClinic.Repository.Usuarios.GerenteRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class GerenteServiceImpl implements GerenteService {
    @Autowired
    private GerenteRepository gerenteRepository;

    @Override
    public List<Gerente> findAll() {
        return gerenteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        gerenteRepository.deleteById(id);
    }

    @Override
    public void save(Gerente gerente) {
        gerenteRepository.save(gerente);
    }

    @Override
    public Gerente getById(Long id) {
        return gerenteRepository.getById(id);
    }
    @Override
    public boolean autorizacionLoginGerente(String correo, String password) {
        Optional<Gerente> optGerente = gerenteRepository.findByCorreo(correo);
        if (optGerente.isPresent()) {
            Gerente usuario = optGerente.get();
            return usuario.getPassword().equals(password);
        }
        return false; // Usuario no encontrado o contraseña incorrecta
    }
}
