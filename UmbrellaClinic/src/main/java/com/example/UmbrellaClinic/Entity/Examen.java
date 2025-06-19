package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    // Al convertir a JSON, este campo será ignorado para evitar referencias cíclicas.
    @JsonBackReference
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idEnfermero")
    // Al convertir a JSON, este campo será ignorado para evitar referencias cíclicas.
    @JsonBackReference("enfermero-examenes")
    private Enfermero enfermero;

    @ManyToOne
    @JoinColumn(name = "idHistorialMedico")
    // Al convertir a JSON, este campo será ignorado para evitar referencias cíclicas.
    @JsonBackReference("historial-examenes") // Nombre único para evitar conflictos
    private HistorialMedico historialMedico;
}