package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Entity.Reporte;
import com.example.UmbrellaClinic.Service.Impl.ReporteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/reporte")
public class ReporteController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private ReporteServiceImpl reporteService;

    // endpoint tipo get para retornar todos los reportes
    @GetMapping("/getReportes")
    public List<Reporte> getReportes() {
        return reporteService.findAll();
    }

    // endpoint tipo get para retornar un reporte segun su id
    @GetMapping("/getReporte/{id}")
    public Reporte getReporte(@PathVariable Long id) {
        return reporteService.getById(id);
    }

    // endpoint tipo post para crear un reporte nuevo
    @PostMapping("/crearReporte")
    public void crearReporte(@RequestBody Reporte reporte) {
        reporteService.save(reporte);
    }

    // endpoint tipo delete para eliminar un reporte por su id
    @DeleteMapping("/eliminarReporte/{id}")
    public void eliminarReporte(@PathVariable Long id) {
        reporteService.deleteById(id);
    }
}
