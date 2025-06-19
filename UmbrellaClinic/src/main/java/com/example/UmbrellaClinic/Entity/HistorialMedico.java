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
    // Se ignoran ciertos atributos del paciente al pasarlo a json
    @JsonIgnoreProperties({"citas", "examenes", "recetas", "historialMedico", "password", "rol"})
    // Al convertir a JSON, este campo será ignorado para evitar referencias cíclicas.
    @JsonBackReference
    private Paciente paciente;

    // Al guardar o eliminar el historial, también se aplican los cambios a sus exámenes.
    // Si se quita un examen de la lista, se elimina automáticamente de la base de datos.
    @OneToMany(mappedBy = "historialMedico", cascade = CascadeType.ALL, orphanRemoval = true)
    // Indica que esta lista será incluida normalmente al convertir a JSON, se evitan ciclos infinitos
    @JsonManagedReference("historial-examenes")
    private List<Examen> examenes;

    // Al guardar o eliminar el historial, también se aplican los cambios a sus exámenes.
    // Si se quita un examen de la lista, se elimina automáticamente de la base de datos.
    @OneToMany(mappedBy = "historialMedico", cascade = CascadeType.ALL, orphanRemoval = true)
    // Indica que esta lista será incluida normalmente al convertir a JSON, se evitan ciclos infinitos
    @JsonManagedReference("historial-recetas")
    private List<Receta> recetas;
}