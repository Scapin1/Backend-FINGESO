package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Gerente;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.GerenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/gerente")
public class GerenteController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private GerenteServiceImpl gerenteService;

    // endpoint tipo get para retornar todos los gerentes
    @GetMapping
    public List<Gerente> getGerente(){
        return gerenteService.findAll();
    }

    // endpoint tipo get para retornar un gerente segun su id
    @GetMapping("/getGerente/{id}")
    public Gerente getGerente(@PathVariable Long id){
        return gerenteService.getById(id);
    }

    // endpoint tipo post para crear un gerente nuevo
    @PostMapping("/crearGerente")
    public void crearGerente(@RequestBody Gerente gerente){
        gerenteService.save(gerente);
    }

    // endpoint tipo delete para eliminar un gerente por su id
    @DeleteMapping("/eliminarGerente/{id}")
    public void eliminarGerente(@PathVariable Long id) {
        gerenteService.deleteById(id);
    }
}
