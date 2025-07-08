package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.DTOs.CrearCitaDisponibleDTO;
import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.Usuarios.MedicoRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.Impl.CitaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/cita")
public class CitaController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private CitaServiceImpl citaService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

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

    @PostMapping("/crearDisponible")
    public ResponseEntity<Cita> crearCitaDisponible(@RequestBody CrearCitaDisponibleDTO dto) {
        Medico medico = medicoRepository.findById(dto.getIdMedico()).orElse(null);
        if (medico == null) return ResponseEntity.badRequest().build();

        Cita nueva = citaService.crearCitaDisponible(dto.getFecha(), dto.getHora(), dto.getSucursal(), medico);
        return ResponseEntity.ok(nueva);
    }
    @GetMapping("/disponibles/medico/{id}")
    public ResponseEntity<List<Cita>> citasDisponiblesPorMedico(@PathVariable("id") Long idMedico) {
        List<Cita> disponibles = citaService.findDisponiblesByMedicoId(idMedico);
        return ResponseEntity.ok(disponibles);
    }
    @PostMapping("/reservar/{idCita}/paciente/{idPaciente}")
    public ResponseEntity<String> reservarCita(
            @PathVariable Long idCita,
            @PathVariable Long idPaciente
    ) {
        try {
            citaService.asignarPacienteACita(idCita, idPaciente);
            return ResponseEntity.ok("Cita reservada exitosamente");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
