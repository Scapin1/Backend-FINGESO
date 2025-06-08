package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;

    @GetMapping("/getpacientes")
    public List<Paciente> GetPacientes(){
        return pacienteService.findAll();
    }
    @PostMapping("/crearpaciente")
    public void CrearPaciente(@RequestBody Paciente paciente){
        pacienteService.save(paciente);
    }
}
