package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Tratamiento;
import com.example.UmbrellaClinic.Service.Impl.TratamientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamiento")
public class TratamientoController {
    @Autowired
    private TratamientoServiceImpl tratamientoService;

    @GetMapping("/getTratamientos")
    public List<Tratamiento> getTratamientos() {
        return tratamientoService.findAll();
    }

    @GetMapping("/getTratamiento/{id}")
    public Tratamiento getTratamiento(Long id) {
        return tratamientoService.getById(id);
    }

    @PostMapping("/crearTratamiento")
    public void crearTratamiento(Tratamiento tratamiento) {
        tratamientoService.save(tratamiento);
    }

    @DeleteMapping("/eliminarTratamiento/{id}")
    public void eliminarTratamiento(@PathVariable Long id) {
        tratamientoService.deleteById(id);
    }
}
