package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Service.Impl.ExamenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examen")
public class ExamenController {
    @Autowired
    private ExamenServiceImpl examenService;

    @GetMapping("/getExamenes")
    public List<Examen> getExamenes() {
        return examenService.findAll();
    }

    @GetMapping("/getExamen/{id}")
    public Examen getExamen(@PathVariable Long id) {
        return examenService.getById(id);
    }

    @PostMapping("/crearExamen")
    public void crearExamen(@RequestBody Examen examen) {
        examenService.save(examen);
    }

    @DeleteMapping("/eliminarExamen/{id}")
    public void eliminarExamen(@PathVariable Long id) {
        examenService.deleteById(id);
    }
}
