package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.QuimicoFarmaceuticoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/quimicoFarmaceutico")
public class QuimicioFarmaceuticoController {
    @Autowired
    private QuimicoFarmaceuticoServiceImpl quimicoFarmaceuticoService;

    @GetMapping("/getQuimicoFarmaceuticos")
    public List<QuimicoFarmaceutico> getQuimicoFarmaceuticos() {
        return quimicoFarmaceuticoService.findAll();
    }

    @GetMapping("/getQuimicoFarmaceutico/{id}")
    public QuimicoFarmaceutico getQuimicoFarmaceutico(@PathVariable Long id) {
        return quimicoFarmaceuticoService.getById(id);
    }

    @PostMapping("/crearQuimicoFarmaceutico")
    public void crearQuimicoFarmaceutico(@RequestBody QuimicoFarmaceutico quimicoFarmaceutico) {
        quimicoFarmaceuticoService.save(quimicoFarmaceutico);
    }

    @DeleteMapping("/eliminarQuimicoFarmaceutico/{id}")
    public void eliminarQuimicoFarmaceutico(@PathVariable Long id) {
        quimicoFarmaceuticoService.deleteById(id);
    }
}
