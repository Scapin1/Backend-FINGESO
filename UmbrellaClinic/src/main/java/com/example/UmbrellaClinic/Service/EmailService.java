package com.example.UmbrellaClinic.Service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Value("${API_CORREO}")
    private String apiCorreo;


    public void sentEmail(String to, String subject, String fecha, String hora, String servicio,String nombre) {
        String html = "<!DOCTYPE html>"
                + "<html><head><meta charset=\"UTF-8\"><title>Confirmación de Reserva</title></head>"
                + "<body style=\"font-family: Arial, sans-serif; background-color: #f6f6f6; padding: 20px;\">"
                + "<div style=\"max-width: 500px; margin: auto; background: #fff; border-radius: 8px; box-shadow: 0 2px 8px #e0e0e0; padding: 30px;\">"
                + "<div style=\"text-align: center;\"><img src=\"https://i.ibb.co/jP1bf6NW/logo-clinica.png\" alt=\"logo-clinica\" style=\"max-width: 150px; margin-bottom: 20px;\" /></div>"
                + "<h2 style=\"color: #2d7ff9;\">¡Reserva Confirmada!</h2>"
                + "<p>Hola, </p>"
                + "<p>Tu reserva ha sido confirmada con éxito. Aquí tienes los detalles:</p>"
                + "<ul>"
                + "<li><strong>Medico:</strong> " + nombre + "</li>"
                + "<li><strong>Fecha:</strong> " + fecha + "</li>"
                + "<li><strong>Hora:</strong> " + hora + "</li>"
                + "<li><strong>Servicio:</strong> " + servicio + "</li>"
                + "</ul>"
                + "<p>Si tienes alguna pregunta, responde a este correo o contáctanos.</p>"
                + "<p style=\"margin-top: 30px;\">Gracias por confiar en Umbrella Clinic.</p>"
                + "</div></body></html>";
        Resend resend = new Resend(apiCorreo);
        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("noreply@umbrellaclinic.software")
                .to(to)
                .subject(subject)
                .html(html)
                .build();
        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }
}
