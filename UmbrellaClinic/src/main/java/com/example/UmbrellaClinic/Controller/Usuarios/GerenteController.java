package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Gerente;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.GerenteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gerente")
public class GerenteController {
    @Autowired
    private GerenteServiceImpl gerenteService;

    @GetMapping
    public List<Gerente> getGerente(){
        return gerenteService.findAll();
    }

    @GetMapping("/getGerente/{id}")
    public Gerente getGerente(@PathVariable Long id){
        return gerenteService.getById(id);
    }

    @GetMapping("/crearGerente")
    public void crearGerente(@RequestBody Gerente gerente){
        gerenteService.save(gerente);
    }

    @GetMapping("/eliminarGerente/{id}")
    public void eliminarGerente(@PathVariable Long id) {
        gerenteService.deleteById(id);
    }
}
