package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.SoporteTecnico;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.SoporteTecnicoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/soporteTecnico")
public class SoporteTecnicoController {
    @Autowired
    private SoporteTecnicoServiceImpl soporteTecnicoService;

    @GetMapping("/getSoporteTecnicos")
    public List<SoporteTecnico> getSoporteTecnicos() {
        return soporteTecnicoService.findAll();
    }

    @GetMapping("/getSoporteTecnico/{id}")
    public SoporteTecnico getSoporteTecnico(@PathVariable Long id) {
        return soporteTecnicoService.getById(id);
    }

    @PostMapping("/crearSoporteTecnico")
    public void crearSoporteTecnico(@RequestBody SoporteTecnico soporteTecnico) {
        soporteTecnicoService.save(soporteTecnico);
    }

    @DeleteMapping("/eliminarSoporteTecnico/{id}")
    public void eliminarSoporteTecnico(@PathVariable Long id) {
        soporteTecnicoService.deleteById(id);
    }
}
