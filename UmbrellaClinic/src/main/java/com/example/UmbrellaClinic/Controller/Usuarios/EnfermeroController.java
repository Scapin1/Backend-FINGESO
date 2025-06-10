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
    @Autowired
    private EnfermeroServiceImpl enfermeroService;

    @GetMapping("/getEnfermeros")
    public List<Enfermero> getEnfermeros() {
        return enfermeroService.findAll();
    }

    @GetMapping("/getEnfermero/{id}")
    public Enfermero getEnfermero(@PathVariable Long id) {
        return enfermeroService.getById(id);
    }

    @PostMapping("/crearEnfermero")
    public void crearEnfermero(@RequestBody Enfermero enfermero) {
        enfermeroService.save(enfermero);
    }

    @DeleteMapping("/eliminarEnfermero/{id}")
    public void eliminarEnfermero(@PathVariable Long id) {
        enfermeroService.deleteById(id);
    }

}
