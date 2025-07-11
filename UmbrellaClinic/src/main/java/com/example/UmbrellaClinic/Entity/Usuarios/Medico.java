package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Entity.Sucursal;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Medico extends Usuario {
    private String especialidad;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("medico-recetas") // Nombre único para esta relación
    private List<Receta> recetas;

    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private List<Cita> citasList;

    @ManyToMany
    @JoinTable(
            name = "medico_sucursal",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "sucursal_id")
    )
    private List<Sucursal> sucursales;
}
