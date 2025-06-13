package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Cita;
import com.example.UmbrellaClinic.Entity.Examen;
import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Receta;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private List<Cita> citas;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    @JsonManagedReference
    private HistorialMedico historialMedico;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Examen> examenes;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Receta> recetas;
}
