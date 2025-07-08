package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CitaExamen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCitaExamen;

    private Date fechaCita;
    private String sucursal;
    private LocalTime horaCita;
    private Boolean eliminada = false;
    private Boolean disponible = true;
    private Boolean agendaPaciente = true;
    private Boolean agendaEnfermero = true;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "enfermero_id")
    private Enfermero enfermero;
}

