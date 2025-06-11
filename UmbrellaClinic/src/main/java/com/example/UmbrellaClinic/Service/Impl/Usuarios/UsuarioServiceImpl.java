package com.example.UmbrellaClinic.Service.Impl.Usuarios;


import com.example.UmbrellaClinic.Service.interfaces.Usuarios.UsuarioService;
import com.example.UmbrellaClinic.Entity.Usuarios.*;
import com.example.UmbrellaClinic.Repository.Usuarios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private PacienteRepository pacienteRepo;
    @Autowired
    private EnfermeroRepository enfermeroRepo;
    @Autowired
    private MedicoRepository medicoRepo;
    @Autowired
    private QuimicoFarmaceuticoRepository quimicoRepo;
    @Autowired
    private GerenteRepository gerenteRepo;
    @Autowired
    private SecretarioRepository secretarioRepo;
    @Autowired
    private SoporteTecnicoRepository soporteRepo;


    public UsuarioServiceImpl(
            PacienteRepository pacienteRepo,
            EnfermeroRepository enfermeroRepo,
            MedicoRepository medicoRepo,
            QuimicoFarmaceuticoRepository quimicoRepo,
            GerenteRepository gerenteRepo,
            SecretarioRepository secretarioRepo,
            SoporteTecnicoRepository soporteRepo) {
        this.pacienteRepo   = pacienteRepo;
        this.enfermeroRepo  = enfermeroRepo;
        this.medicoRepo     = medicoRepo;
        this.quimicoRepo    = quimicoRepo;
        this.gerenteRepo    = gerenteRepo;
        this.secretarioRepo = secretarioRepo;
        this.soporteRepo    = soporteRepo;
    }

    @Override
    public Integer verificarTipoUsuario(String correo) {
        // como cada findByCorreo devuelve Optional<...>, puedes usar isPresent()
        if (pacienteRepo.findByCorreo(correo).isPresent()) {
            return 1;
        }
        if (enfermeroRepo.findByCorreo(correo).isPresent()) {
            return 2;
        }
        if (medicoRepo.findByCorreo(correo).isPresent()) {
            return 3;
        }
        if (quimicoRepo.findByCorreo(correo).isPresent()) {
            return 4;
        }
        if (gerenteRepo.findByCorreo(correo).isPresent()) {
            return 5;
        }
        if (secretarioRepo.findByCorreo(correo).isPresent()) {
            return 6;
        }
        if (soporteRepo.findByCorreo(correo).isPresent()) {
            return 7;
        }
        return 0;
    }
}