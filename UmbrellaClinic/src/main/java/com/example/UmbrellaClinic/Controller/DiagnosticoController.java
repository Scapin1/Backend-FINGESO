package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Diagnostico;
import com.example.UmbrellaClinic.Service.Impl.DiagnosticoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/diagnostico")
public class DiagnosticoController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private DiagnosticoServiceImpl diagnosticoService;

    // endpoint tipo get para retornar todos los diagnosticos
    @GetMapping("/getDiagnosticos")
    public List<Diagnostico> getDiagnosticos() {
        return diagnosticoService.findAll();
    }

    // endpoint tipo get para retornar un diagnostico segun su id
    @GetMapping("/getDiagnostico/{id}")
    public Diagnostico getDiagnostico(@PathVariable Long id) {
        return diagnosticoService.getById(id);
    }

    // endpoint tipo post para crear un diagnostico nuevo
    @PostMapping("/crearDiagnostico")
    public void crearDiagnostico(@RequestBody Diagnostico diagnostico) {
        diagnosticoService.save(diagnostico);
    }

    // endpoint tipo delete para eliminar un diagnostico por su id
    @DeleteMapping("/eliminarDiagnostico/{id}")
    public void eliminarDiagnostico(@PathVariable Long id) {
        diagnosticoService.deleteById(id);
    }
}
