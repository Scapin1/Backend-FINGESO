package com.example.UmbrellaClinic.Entity;


import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "UTC")
    private Date fechaEmision;
    private String observaciones;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX", timezone = "UTC")
    private Date vigencia;
    private Boolean estado = false;//true si esta entregada, false si no se a entregado
    @ManyToOne
    @JoinColumn(name = "medico_id") // Clave foránea para Medico
    // Al convertir a JSON, este campo será ignorado para evitar referencias cíclicas.
    @JsonBackReference("medico-recetas")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id") // Define la columna de clave foránea en la tabla 'receta'
    // Al convertir a JSON, este campo será ignorado para evitar referencias cíclicas.
    @JsonBackReference
    private Paciente paciente; // El objeto Paciente asociado a esta receta

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "medicamento_receta", // El mismo nombre de tabla de unión
            joinColumns = @JoinColumn(name = "receta_id", referencedColumnName = "idReceta") , // Columna para el ID de Receta en la tabla de unión
            inverseJoinColumns = @JoinColumn(name = "medicamento_id", referencedColumnName = "idMedicamento") // Columna para el ID de Medicamento en la tabla de unión
    )
    private List<Medicamento> medicamentosList;

    //esto deve estar en una tabla intermedia despues
    private List<Integer> cantidadMedicamentos;

    @Column(name = "examen_indicado")
    private String examenIndicado;

    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "idHistorialMedico")
    // Al convertir a JSON, este campo será ignorado para evitar referencias cíclicas.
    @JsonBackReference("historial-recetas")
    private HistorialMedico historialMedico;

    private Boolean reservarSinSock = false;

    @Transient
    private List<Medicamento> medicamentosSinStock;

}
