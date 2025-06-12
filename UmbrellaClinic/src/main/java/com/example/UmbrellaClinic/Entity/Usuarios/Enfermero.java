package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.HistorialMedico;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Enfermero extends Usuario {


    @OneToMany(mappedBy = "enfermero")
    private List<Examen> examenList;
}
