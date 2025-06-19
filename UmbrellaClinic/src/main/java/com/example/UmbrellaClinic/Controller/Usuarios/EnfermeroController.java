package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.EnfermeroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/enfermero")
public class EnfermeroController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private EnfermeroServiceImpl enfermeroService;

    // endpoint tipo get para retornar todos los enfermeros
    @GetMapping("/getEnfermeros")
    public List<Enfermero> getEnfermeros() {
        return enfermeroService.findAll();
    }

    // endpoint tipo get para retornar un enfermero segun su id
    @GetMapping("/getEnfermero/{id}")
    public Enfermero getEnfermero(@PathVariable Long id) {
        return enfermeroService.getById(id);
    }

    // endpoint tipo post para crear un enfermero nuevo
    @PostMapping("/crearEnfermero")
    public void crearEnfermero(@RequestBody Enfermero enfermero) {
        enfermeroService.save(enfermero);
    }

    // endpoint tipo delete para eliminar un enfermero por su id
    @DeleteMapping("/eliminarEnfermero/{id}")
    public void eliminarEnfermero(@PathVariable Long id) {
        enfermeroService.deleteById(id);
    }
}
