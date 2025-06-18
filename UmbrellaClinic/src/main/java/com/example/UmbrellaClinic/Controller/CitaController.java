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
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private CitaServiceImpl citaService;

    // endpoint tipo get para retornar todas las citas
    @GetMapping("/getCitas")
    public List<Cita> getCitas() {
        return citaService.findAll();
    }

    // endpoint tipo get para retornar una cita segun su id
    @GetMapping("/getCita/{id}")
    public Cita getCita(@PathVariable Long id) {
        return citaService.getById(id);
    }

    // endpoint tipo post para crear una cita nueva
    @PostMapping("/crearCita")
    public void crearCita(@RequestBody Cita cita) {
        citaService.save(cita);
    }

    // endpoint tipo put para eliminar (marcar como eliminada) una cita por su id
    @PutMapping("/eliminarCita/{id}")
    public void eliminarCita(@PathVariable Long id) {
        citaService.deleteById(id);
    }

    // endpoint tipo get para retornar las citas pendientes asociadas a un usuario
    @GetMapping("/citasPendientes/{userId}")
    public List<Cita> getCitasPendientes(@PathVariable("userId") Long userId) {
        return citaService.findcitasPendientes(userId);
    }

    // endpoint tipo put para marcar que una cita fue atendida por el medico
    @PutMapping("/atendidoPorMedico/{id}")
    public void atendidoPorMedico(@PathVariable Long id) {
        citaService.atendidoPorMedico(id);
    }

    // endpoint tipo put para marcar que el paciente llegó a la cita
    @PutMapping("/llegadaPaciente/{id}")
    public void llegadaPaciente(@PathVariable Long id) {
        citaService.llegadaPaciente(id);
    }
}
