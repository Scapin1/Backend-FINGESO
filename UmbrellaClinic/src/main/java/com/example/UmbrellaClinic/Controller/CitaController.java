package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Service.Impl.CitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/cita")
public class CitaController {
    @Autowired
    private CitaServiceImpl citaService;

    @GetMapping("/getCitas")
    public List<Cita> getCitas() {
        return citaService.findAll();
    }

    @GetMapping("/getCita/{id}")
    public Cita getCita(@PathVariable Long id) {
        return citaService.getById(id);
    }

    @PostMapping("/crearCita")
    public void crearCita(@RequestBody Cita cita) {
        citaService.save(cita);
    }

    @PutMapping("/eliminarCita/{id}")
    public void eliminarCita(@PathVariable Long id) {
        Cita cita = citaService.getById(id);
        if (cita != null) {
            cita.setEliminada(true); // Cambia el estado de la cita a eliminada
            citaService.save(cita); // Guarda la cita actualizada
        }
    }

    @GetMapping("/citasPendientes/{userId}")
    public List<Cita> getCitasPendientes(@PathVariable("userId") Long userId) {
        return citaService.findcitasPendientes(userId);
    }
}
