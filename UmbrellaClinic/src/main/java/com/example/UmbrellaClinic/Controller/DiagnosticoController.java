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
    @Autowired
    private DiagnosticoServiceImpl diagnosticoService;

    @GetMapping("/getDiagnosticos")
    public List<Diagnostico> getDiagnosticos() {
        return diagnosticoService.findAll();
    }

    @GetMapping("/getDiagnostico/{id}")
    public Diagnostico getDiagnostico(@PathVariable Long id) {
        return diagnosticoService.getById(id);
    }

    @PostMapping("/crearDiagnostico")
    public void crearDiagnostico(@RequestBody Diagnostico diagnostico) {
        diagnosticoService.save(diagnostico);
    }

    @DeleteMapping("/eliminarDiagnostico/{id}")
    public void eliminarDiagnostico(@PathVariable Long id) {
        diagnosticoService.deleteById(id);
    }
}
