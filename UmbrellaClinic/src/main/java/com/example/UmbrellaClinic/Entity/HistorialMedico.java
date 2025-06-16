package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class HistorialMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idHistorialMedico;

    @OneToOne
    @JoinColumn(name = "idPaciente")
    @JsonIgnoreProperties({"citas", "examenes", "recetas", "historialMedico", "password", "rol"})
    @JsonBackReference
    private Paciente paciente;

    @OneToMany(mappedBy = "historialMedico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("historial-examenes")
    private List<Examen> examenes;

    @OneToMany(mappedBy = "historialMedico", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("historial-recetas")
    private List<Receta> recetas;
}