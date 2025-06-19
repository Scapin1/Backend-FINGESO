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

    // Al guardar o eliminar el paciente, también se aplican los cambios a su historial.
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    // Indica que esta lista será incluida normalmente al convertir a JSON, se evitan ciclos infinitos
    @JsonManagedReference
    private HistorialMedico historialMedico;

    // Al guardar o eliminar el paciente, también se aplican los cambios a sus exámenes.
    // Si se quita un examen de la lista, se elimina automáticamente de la base de datos.
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    // Indica que esta lista será incluida normalmente al convertir a JSON, se evitan ciclos infinitos
    @JsonManagedReference
    private List<Examen> examenes;

    // Al guardar o eliminar el paciente, también se aplican los cambios a las recetas.
    // Si se quita una receta de la lista, se elimina automáticamente de la base de datos.
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    // Indica que esta lista será incluida normalmente al convertir a JSON, se evitan ciclos infinitos
    @JsonManagedReference
    private List<Receta> recetas;
}
