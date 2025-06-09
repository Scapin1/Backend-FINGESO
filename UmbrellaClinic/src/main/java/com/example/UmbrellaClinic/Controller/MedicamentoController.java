package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Service.Impl.MedicamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/medicamento")
public class MedicamentoController {
    @Autowired
    private MedicamentoServiceImpl medicamentoService;

    @GetMapping("/getMedicamentos")
    public List<Medicamento> getMedicamentos() {
        return medicamentoService.findAll();
    }

    @GetMapping("/getMedicamento/{id}")
    public Medicamento getMedicamento(@PathVariable Long id) {
        return medicamentoService.getById(id);
    }

    @PostMapping("/crearMedicamento")
    public void crearMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoService.save(medicamento);
    }

    @DeleteMapping("/eliminarMedicamento/{id}")
    public void eliminarMedicamento(@PathVariable Long id) {
        medicamentoService.deleteById(id);
    }
}
