package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.MedicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/medico")
public class MedicoController {
    @Autowired
    private MedicoServiceImpl medicoService;

    @GetMapping("/getMedicos")
    public List<Medico> getMedicos(){
        return medicoService.findAll();
    }

    @GetMapping("/getMedico/{id}")
    public Medico getMedico(@PathVariable Long id){
        return medicoService.getById(id);
    }

    @PostMapping("/crearMedico")
    public void crearMedico(@RequestBody Medico medico){
        medicoService.save(medico);
    }

    @DeleteMapping("/eliminarMedico/{id}")
    public void eliminarMedico(@PathVariable Long id) {
        medicoService.deleteById(id);
    }
}
