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
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private QuimicoFarmaceuticoServiceImpl quimicoFarmaceuticoService;

    // endpoint tipo get para retornar todos los quimicos farmaceuticos
    @GetMapping("/getQuimicoFarmaceuticos")
    public List<QuimicoFarmaceutico> getQuimicoFarmaceuticos() {
        return quimicoFarmaceuticoService.findAll();
    }

    // endpoint tipo get para retornar un quimico farmaceutico segun su id
    @GetMapping("/getQuimicoFarmaceutico/{id}")
    public QuimicoFarmaceutico getQuimicoFarmaceutico(@PathVariable Long id) {
        return quimicoFarmaceuticoService.getById(id);
    }

    // endpoint tipo post para crear un quimico farmaceutico nuevo
    @PostMapping("/crearQuimicoFarmaceutico")
    public void crearQuimicoFarmaceutico(@RequestBody QuimicoFarmaceutico quimicoFarmaceutico) {
        quimicoFarmaceuticoService.save(quimicoFarmaceutico);
    }

    // endpoint tipo delete para eliminar un quimico farmaceutico por su id
    @DeleteMapping("/eliminarQuimicoFarmaceutico/{id}")
    public void eliminarQuimicoFarmaceutico(@PathVariable Long id) {
        quimicoFarmaceuticoService.deleteById(id);
    }
}
