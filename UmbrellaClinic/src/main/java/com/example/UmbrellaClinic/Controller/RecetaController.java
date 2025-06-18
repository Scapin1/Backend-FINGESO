package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Service.Impl.RecetaServiceImpl;
import com.example.UmbrellaClinic.Service.interfaces.MedicamentoService;
import com.example.UmbrellaClinic.Service.interfaces.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/receta")
public class RecetaController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private RecetaServiceImpl recetaService;
    // endpoint tipo get para retornar todas las recetas
    // no se si se llegue a usar
    @GetMapping("/getRecetas")
    public List<Receta> getRecetas() {
        return recetaService.findAll();
    }
    // endpoint tipo get para retornar una receta segun su id
    @GetMapping("/getReceta/{id}")
    public Receta getReceta(@PathVariable Long id) {
        return recetaService.getById(id);
    }
    // endpoint tipo post para crear una receta nueva
    @PostMapping("/crearReceta")
    public Receta crearReceta(@RequestBody Receta receta) {
        return recetaService.createReceta(receta);
    }
    // endpoint tipo delete para eliminar una receta por su id
    @DeleteMapping("/eliminarReceta/{id}")
    public void eliminarReceta(@PathVariable Long id) {
    }
    // endpoint tipo get para retornar recetas por el rut del paciente asociado
    @GetMapping("/porPacienteRut/{rutPaciente}") // Cambiado el nombre del endpoint para mayor claridad
    public ResponseEntity<List<Receta>> getRecetasByRutPaciente(@PathVariable String rutPaciente) {
        List<Receta> recetas = recetaService.findByPacienteRut(rutPaciente);
        if (!recetas.isEmpty()) {
            return new ResponseEntity<>(recetas, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // endpoint tipo put para entregar la receta a un paciente segun el id de la receta y actualizar el stock
    @PutMapping("/entregarReceta/{id_receta}")
    public void entregarReceta(@PathVariable Long id_receta){
        recetaService.entregarReceta(id_receta);
    }
}
