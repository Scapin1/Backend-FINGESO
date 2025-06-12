package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.Receta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private List<Receta> recetas;

    @OneToMany(mappedBy = "medico")
    @JsonIgnore
    private List<Cita> citasList;
}
