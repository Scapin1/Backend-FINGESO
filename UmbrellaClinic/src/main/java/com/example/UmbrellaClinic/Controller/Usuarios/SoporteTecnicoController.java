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
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private SoporteTecnicoServiceImpl soporteTecnicoService;

    // endpoint tipo get para retornar todos los usuarios de soporte tecnico
    @GetMapping("/getSoporteTecnicos")
    public List<SoporteTecnico> getSoporteTecnicos() {
        return soporteTecnicoService.findAll();
    }

    // endpoint tipo get para retornar un usuario de soporte tecnico segun su id
    @GetMapping("/getSoporteTecnico/{id}")
    public SoporteTecnico getSoporteTecnico(@PathVariable Long id) {
        return soporteTecnicoService.getById(id);
    }

    // endpoint tipo post para crear un usuario de soporte tecnico nuevo
    @PostMapping("/crearSoporteTecnico")
    public void crearSoporteTecnico(@RequestBody SoporteTecnico soporteTecnico) {
        soporteTecnicoService.save(soporteTecnico);
    }

    // endpoint tipo delete para eliminar un usuario de soporte tecnico por su id
    @DeleteMapping("/eliminarSoporteTecnico/{id}")
    public void eliminarSoporteTecnico(@PathVariable Long id) {
        soporteTecnicoService.deleteById(id);
    }
}
