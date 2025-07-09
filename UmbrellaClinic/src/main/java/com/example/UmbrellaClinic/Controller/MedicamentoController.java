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
    // se inyectan las dependencias de su capa de servicios
    // MedicamentoServiceImpl logica de negocios
    @Autowired
    private MedicamentoServiceImpl medicamentoService;
    // endpoint tipo get para retornar los medicamentos llamando a medicamentoService.findAll()
    @GetMapping("/getMedicamentos")
    public List<Medicamento> getMedicamentos() {
        return medicamentoService.findAll();
    }
    // endpoint tipo get para retornar un medicamento por su id
    @GetMapping("/getMedicamento/{id}")
    public Medicamento getMedicamento(@PathVariable Long id) {
        return medicamentoService.getById(id);
    }
    // endpoint tipo get para retornar un medicamento po su nombre Comercial
    @GetMapping("/getMedicamentoPorNombre/{nombre}")
    public Medicamento getMedicamentoPorNombre(@PathVariable String nombre) {
        return medicamentoService.getByNombreComercial(nombre);
    }
    // endpoint tipo post para crear un medicamento
    @PostMapping("/crearMedicamento")
    public void crearMedicamento(@RequestBody Medicamento medicamento) {
        medicamentoService.save(medicamento);
    }
    // endpoint tipo delete para eliminar un medicamento segun su id
    @DeleteMapping("/eliminarMedicamento/{id}")
    public void eliminarMedicamento(@PathVariable Long id) {
        medicamentoService.deleteById(id);
    }

    //estos ultimos dos deverian ser PUT no post

    // endpoint del tipo put para reabastecer un medicamentos a partir de su nombre comercial y una cantidad de medicamento que llega a bodega
    @PutMapping("/reabastecerMedicamentos/{id}/{cantidad}")
    public void reabastecerMedicamentos(@PathVariable Long id,@PathVariable int cantidad) {
        medicamentoService.reabastecerMedicamentos(id, cantidad);
    }
    // endpoint tipo Post para entregar un medicamento/s a un paciente
    @PutMapping("/entregarMedicamentos/{id}/{cantidad}")
    public  void entregarMedicamentos(@PathVariable Long id,@PathVariable int cantidad) {
        medicamentoService.entregarMedicamentos(id,cantidad);
    }
}
