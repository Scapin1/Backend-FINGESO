package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Secretario;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.SecretarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/secretario")
public class SecretarioController {
    @Autowired
    private SecretarioServiceImpl secretarioService;

    @GetMapping("/getSecretarios")
    public List<Secretario> getSecretarios() {
        return secretarioService.findAll();
    }

    @GetMapping("/getSecretario/{id}")
    public Secretario getSecretario(@PathVariable Long id) {
        return secretarioService.getById(id);
    }

    @PostMapping("/crearSecretario")
    public void crearSecretario(@RequestBody Secretario secretario) {
        secretarioService.save(secretario);
    }

    @DeleteMapping("/eliminarSecretario/{id}")
    public void eliminarSecretario(@PathVariable Long id) {
        secretarioService.deleteById(id);
    }
}
