package com.example.UmbrellaClinic.Controller;

import com.example.UmbrellaClinic.Service.EmailService;
import com.resend.Resend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {
    @Autowired
    EmailService resend;

    @PostMapping("/sentEmail")
    public void sentEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String fecha, @RequestParam String hora, @RequestParam String servicio,@RequestParam String nombre) {
        resend.sentEmail(to, subject, fecha, hora, servicio, nombre);
    }


}
