package com.example.UmbrellaClinic.Entity;


import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
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
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;
    private Date fechaEmision;
    private String observaciones;
    private Date vigencia;
    private String estado;
    @ManyToOne
    @JoinColumn(name = "medico_id") // Clave foránea para Medico
    private Medico medico;

    // *** NUEVA RELACIÓN MANY-TO-ONE CON PACIENTE ***
    @ManyToOne
    @JoinColumn(name = "paciente_id") // Define la columna de clave foránea en la tabla 'receta'
    private Paciente paciente; // El objeto Paciente asociado a esta receta
}
