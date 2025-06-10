package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Receta;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente extends Usuario {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Cita> citasList;

    @OneToOne
    private HistorialMedico historialMedico;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Examen> examenList;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Receta> recetas; // Una lista de recetas de este paciente
}
