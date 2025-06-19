package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enfermero extends Usuario {


    @OneToMany(mappedBy = "enfermero", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("enfermero-examenes") // Nombre único para esta relación
    private List<Examen> examenList;
}
