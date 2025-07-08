package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.DTOs.CrearCitaExamenDisponibleDTO;
import com.example.UmbrellaClinic.Entity.CitaExamen;
import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Repository.Usuarios.EnfermeroRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.Impl.CitaExamenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/citaExamen")
public class CitaExamenController {

    @Autowired
    private CitaExamenServiceImpl citaService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnfermeroRepository enfermeroRepository;

    // Obtener todas las citas de examen
    @GetMapping("/getCitas")
    public List<CitaExamen> getCitas() {
        return citaService.findAll();
    }

    // Obtener una cita de examen por su ID
    @GetMapping("/getCita/{id}")
    public CitaExamen getCita(@PathVariable Long id) {
        return citaService.getById(id);
    }

    // Crear una nueva cita de examen
    @PostMapping("/crearCita")
    public void crearCita(@RequestBody CitaExamen cita) {
        citaService.save(cita);
    }

    // Marcar como eliminada una cita de examen
    @PutMapping("/eliminarCita/{id}")
    public void eliminarCita(@PathVariable Long id) {
        citaService.deleteById(id);
    }

    // Obtener las citas pendientes de examen de un usuario
    @GetMapping("/citasPendientes/{userId}")
    public List<CitaExamen> getCitasPendientes(@PathVariable("userId") Long userId) {
        return citaService.findCitasPendientes(userId);
    }

    // Marcar que una cita fue atendida por el enfermero
    @PutMapping("/atendidoPorEnfermero/{id}")
    public void atendidoPorEnfermero(@PathVariable Long id) {
        citaService.atendidoPorEnfermero(id);
    }

    // Marcar que un paciente llegó a su cita
    @PutMapping("/llegadaPaciente/{id}")
    public void llegadaPaciente(@PathVariable Long id) {
        citaService.llegadaPaciente(id);
    }

    // Crear una cita de examen disponible para un enfermero
    @PostMapping("/crearDisponible")
    public ResponseEntity<CitaExamen> crearCitaDisponible(@RequestBody CrearCitaExamenDisponibleDTO dto) {
        Enfermero enfermero = enfermeroRepository.findById(dto.getIdEnfermero()).orElse(null);
        if (enfermero == null) return ResponseEntity.badRequest().build();

        CitaExamen nueva = citaService.crearCitaDisponible(dto.getFecha(), dto.getHora(), dto.getSucursal(), enfermero);
        return ResponseEntity.ok(nueva);
    }

    // Obtener citas disponibles de examen por ID del enfermero
    @GetMapping("/disponibles/enfermero/{id}")
    public ResponseEntity<List<CitaExamen>> citasDisponiblesPorEnfermero(@PathVariable("id") Long idEnfermero) {
        List<CitaExamen> disponibles = citaService.findDisponiblesByEnfermeroId(idEnfermero);
        return ResponseEntity.ok(disponibles);
    }

    // Asignar un paciente a una cita de examen disponible
    @PostMapping("/reservar/{idCita}/paciente/{idPaciente}")
    public ResponseEntity<String> reservarCita(
            @PathVariable Long idCita,
            @PathVariable Long idPaciente
    ) {
        try {
            citaService.asignarPacienteACita(idCita, idPaciente);
            return ResponseEntity.ok("Cita de examen reservada exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

