package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHistorialMedico;

    @OneToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @OneToMany(mappedBy = "historialMedico")
    @JsonIgnore
    private List<Examen> examenList;
}
