package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;

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
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaConvertida = LocalDate.parse(fecha, formato);

        resend.sentEmail(to, subject, fecha, hora, servicio, nombre);
        resend.sentEmailScheduled(to, fecha, hora, servicio, nombre, String.valueOf(fechaConvertida.minusDays(1)));
    }
}
