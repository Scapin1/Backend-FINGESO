package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.MedicoRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;

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
        medicoRepository.save(medico);
    }

    @Override
    public Medico getById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public boolean autorizacionLoginMedico(String correo, String password) {
        Optional<Medico> optMedico = medicoRepository.findByCorreo(correo);
        if (optMedico.isPresent()) {
            Medico usuario = optMedico.get();
            return usuario.getPassword().equals(password);
        }
        return false; // Usuario no encontrado o contraseña incorrecta
    }
}
