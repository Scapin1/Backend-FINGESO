package com.example.UmbrellaClinic.Controller.Usuarios;

import com.example.UmbrellaClinic.Entity.Usuarios.Secretario;
import com.example.UmbrellaClinic.Service.Impl.Usuarios.SecretarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/secretario")
public class    SecretarioController {
    // inyectar dependencias para conectar con la logica de negocios
    @Autowired
    private SecretarioServiceImpl secretarioService;

    // endpoint tipo get para retornar todos los secretarios
    @GetMapping("/getSecretarios")
    public List<Secretario> getSecretarios() {
        return secretarioService.findAll();
    }

    // endpoint tipo get para retornar un secretario segun su id
    @GetMapping("/getSecretario/{id}")
    public Secretario getSecretario(@PathVariable Long id) {
        return secretarioService.getById(id);
    }

    // endpoint tipo post para crear un secretario nuevo
    @PostMapping("/crearSecretario")
    public void crearSecretario(@RequestBody Secretario secretario) {
        secretarioService.save(secretario);
    }

    // endpoint tipo delete para eliminar un secretario por su id
    @DeleteMapping("/eliminarSecretario/{id}")
    public void eliminarSecretario(@PathVariable Long id) {
        secretarioService.deleteById(id);
    }
}
