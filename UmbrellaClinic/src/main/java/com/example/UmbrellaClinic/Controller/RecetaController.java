package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Service.Impl.RecetaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receta")
public class RecetaController {
    @Autowired
    private RecetaServiceImpl recetaService;

    @GetMapping("/getRecetas")
    public List<Receta> getRecetas() {
        return recetaService.findAll();
    }

    @GetMapping("/getReceta/{id}")
    public Receta getReceta(@PathVariable Long id) {
        return recetaService.getById(id);
    }

    @PostMapping("/crearReceta")
    public void crearReceta(@RequestBody Receta receta) {
        recetaService.save(receta);
    }

    @DeleteMapping("/eliminarReceta/{id}")
    public void eliminarReceta(@PathVariable Long id) {
        recetaService.deleteById(id);
    }
}
