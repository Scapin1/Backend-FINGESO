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
    @Autowired
    private ReporteServiceImpl reporteService;

    @GetMapping("/getReportes")
    public List<Reporte> getReportes() {
        return reporteService.findAll();
    }

    @GetMapping("/getReporte/{id}")
    public Reporte getReporte(@PathVariable Long id) {
        return reporteService.getById(id);
    }

    @PostMapping("/crearReporte")
    public void crearReporte(@RequestBody Reporte reporte) {
        reporteService.save(reporte);
    }

    @DeleteMapping("/eliminarReporte/{id}")
    public void eliminarReporte(@PathVariable Long id) {
        reporteService.deleteById(id);
    }
}
