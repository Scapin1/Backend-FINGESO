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
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private MedicoServiceImpl medicoService;

    // endpoint tipo get para retornar todos los medicos
    @GetMapping("/getMedicos")
    public List<Medico> getMedicos(){
        return medicoService.findAll();
    }

    // endpoint tipo get para retornar un medico segun su id
    @GetMapping("/getMedico/{id}")
    public Medico getMedico(@PathVariable Long id){
        return medicoService.getById(id);
    }

    // endpoint tipo post para crear un medico nuevo
    @PostMapping("/crearMedico")
    public void crearMedico(@RequestBody Medico medico){
        medicoService.save(medico);
    }

    // endpoint tipo delete para eliminar un medico por su id
    @DeleteMapping("/eliminarMedico/{id}")
    public void eliminarMedico(@PathVariable Long id) {
        medicoService.deleteById(id);
    }
}
