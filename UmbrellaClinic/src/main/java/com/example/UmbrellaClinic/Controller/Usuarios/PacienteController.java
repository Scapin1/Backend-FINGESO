package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/paciente")
public class PacienteController {
    @Autowired
    private PacienteServiceImpl pacienteService;

    @GetMapping("/getPacientes")
    public List<Paciente> GetPacientes(){
        return pacienteService.findAll();
    }

    @GetMapping("/getPaciente/{id}")
    public Paciente GetPaciente(@PathVariable Long id){
        return pacienteService.getById(id);
    }

    @PostMapping("/crearPaciente")
    public void CrearPaciente(@RequestBody Paciente paciente){
        pacienteService.save(paciente);
    }

    @DeleteMapping("/eliminarPaciente/{id}")
    public void EliminarPaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }

    @GetMapping("/getIdByRut/{rut}")
    public int getIdByRut(@PathVariable String rut) {
        return pacienteService.getIdByRut(rut);
    }

    @GetMapping("/{id}/historial")
    public Object getHistorialPorId(@PathVariable Long id) {
        HistorialMedico historial = pacienteService.getHistorialOrdenado(id);
        if (historial != null) {
            if (historial.getExamenes() != null) {
                Collections.reverse(historial.getExamenes());
            }
            if (historial.getRecetas() != null) {
                Collections.reverse(historial.getRecetas());
            }
            return historial;
        } else {
            return "Historial no encontrado";
        }
    }
    @PutMapping("/updatePaciente/{id}")
    public void updatePaciente(@RequestParam String nombre, @RequestParam String contraseña, @PathVariable Long id) {
        pacienteService.updatePaciente(nombre, contraseña, id);
    }
}
