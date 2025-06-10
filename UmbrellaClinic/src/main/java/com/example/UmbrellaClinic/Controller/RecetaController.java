package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Service.Impl.RecetaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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
    }
    @GetMapping("/porPacienteRut/{rutPaciente}") // Cambiado el nombre del endpoint para mayor claridad
    public ResponseEntity<List<Receta>> getRecetasByRutPaciente(@PathVariable String rutPaciente) {
        List<Receta> recetas = recetaService.findByPacienteRut(rutPaciente);
        if (!recetas.isEmpty()) {
            return new ResponseEntity<>(recetas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
