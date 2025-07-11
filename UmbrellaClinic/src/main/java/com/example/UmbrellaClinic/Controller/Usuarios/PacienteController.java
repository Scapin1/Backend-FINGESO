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
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private PacienteServiceImpl pacienteService;

    // endpoint tipo get para retornar todos los pacientes
    @GetMapping("/getPacientes")
    public List<Paciente> GetPacientes(){
        return pacienteService.findAll();
    }

    // endpoint tipo get para retornar un paciente segun su id
    @GetMapping("/getPaciente/{id}")
    public Paciente GetPaciente(@PathVariable Long id){
        return pacienteService.getById(id);
    }

    // endpoint tipo post para crear un paciente nuevo
        @PostMapping("/crearPaciente")
        public Paciente CrearPaciente(@RequestBody Paciente paciente){
            return pacienteService.save(paciente);
        }

    // endpoint tipo delete para eliminar un paciente por su id
    @DeleteMapping("/eliminarPaciente/{id}")
    public void EliminarPaciente(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }

    // endpoint tipo get para obtener el id de un paciente por su rut
    @GetMapping("/getIdByRut/{rut}")
    public int getIdByRut(@PathVariable String rut) {
        return pacienteService.getIdByRut(rut);
    }

    // endpoint tipo get para retornar el historial medico del paciente ordenado desc a travez del id
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

    // endpoint tipo put para actualizar el nombre y contraseña de un paciente
    @PutMapping("/updatePaciente/{id}")
    public void updatePaciente(@RequestParam String nombre, @RequestParam String contraseña, @PathVariable Long id) {
        pacienteService.updatePaciente(nombre, contraseña, id);
    }
}
