package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {
    // inyectar dependencias para conectar con el servicio de envío de correos
    @Autowired
    EmailService resend;

    // endpoint tipo post para enviar un correo con los datos de la cita
    @PostMapping("/sentEmail")
    public void sentEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String fecha,
            @RequestParam String hora,
            @RequestParam String servicio,
            @RequestParam String nombre
    ) {
        resend.sentEmail(to, subject, fecha, hora, servicio, nombre);
    }
}
