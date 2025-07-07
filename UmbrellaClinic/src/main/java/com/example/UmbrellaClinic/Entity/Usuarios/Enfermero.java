package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Sucursal;
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

    @ManyToMany
    @JoinTable(
            name = "enfermero_sucursal",
            joinColumns = @JoinColumn(name = "enfermero_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id")
    )
    private List<Sucursal> sucursales;
}
