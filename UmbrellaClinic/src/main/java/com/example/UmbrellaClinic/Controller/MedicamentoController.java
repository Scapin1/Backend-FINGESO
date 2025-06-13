package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Service.Impl.MedicamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/getMedicamentoPorNombre/{nombre}")
    public Medicamento getMedicamentoPorNombre(@PathVariable String nombre) {
        return medicamentoService.getByNombreComercial(nombre);
    }
    @PostMapping("/crearMedicamento")
    public void crearMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoService.save(medicamento);
    }

    @DeleteMapping("/eliminarMedicamento/{id}")
    public void eliminarMedicamento(@PathVariable Long id) {
        medicamentoService.deleteById(id);
    }

    @PostMapping("/actualizarStockMedicamentos/{nombreComercial}/{tipo}/{cantidad}")
    public void actualizarStockMedicamentos(@PathVariable String nombreComercial,@PathVariable int tipo,@PathVariable int cantidad) {
        medicamentoService.actualizarStockMedicamentos(nombreComercial,tipo,cantidad);
    }
}
