package com.example.UmbrellaClinic.Entity;


import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;
    private Date fechaEmision;
    private String observaciones;
    private Date vigencia;
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "medico_id") // Clave foránea para Medico
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id") // Define la columna de clave foránea en la tabla 'receta'
    @JsonBackReference
    private Paciente paciente; // El objeto Paciente asociado a esta receta

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "medicamento_receta", // El mismo nombre de tabla de unión
            joinColumns = @JoinColumn(name = "receta_id", referencedColumnName = "idReceta") , // Columna para el ID de Receta en la tabla de unión
            inverseJoinColumns = @JoinColumn(name = "medicamento_id", referencedColumnName = "idMedicamento") // Columna para el ID de Medicamento en la tabla de unión
    )
    private List<Medicamento> medicamentosList;

    //cambios que quiero consultar
    private String examenIndicado;
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "idHistorialMedico")
    @JsonBackReference("historial-examenes")
    private HistorialMedico historialMedico;
}
