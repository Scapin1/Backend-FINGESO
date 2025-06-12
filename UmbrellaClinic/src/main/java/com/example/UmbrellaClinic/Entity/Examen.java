package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExamen;
    private String tipo;
    private Date fechaExamen;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idEnfermero")
    private Enfermero enfermero;

    @ManyToOne
    @JoinColumn(name = "idHistorialMedico")
    private HistorialMedico historialMedico;
}
