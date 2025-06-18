package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Service.Impl.ExamenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/examen")
public class ExamenController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private ExamenServiceImpl examenService;

    // endpoint tipo get para retornar todos los examenes
    @GetMapping("/getExamenes")
    public List<Examen> getExamenes() {
        return examenService.findAll();
    }

    // endpoint tipo get para retornar un examen segun su id
    @GetMapping("/getExamen/{id}")
    public Examen getExamen(@PathVariable Long id) {
        return examenService.getById(id);
    }

    // endpoint tipo post para crear un examen nuevo
    @PostMapping("/crearExamen")
    public void crearExamen(@RequestBody Examen examen) {
        examenService.createExamen(examen);
    }

    // endpoint tipo delete para eliminar un examen por su id
    @DeleteMapping("/eliminarExamen/{id}")
    public void eliminarExamen(@PathVariable Long id) {
        examenService.deleteById(id);
    }
}
