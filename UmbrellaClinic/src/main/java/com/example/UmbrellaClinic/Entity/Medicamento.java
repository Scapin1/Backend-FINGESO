package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Medicamento {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long idMedicamento;
    private String nombreComercial;
    private String principioActivo;
    private String tipoMedicamento;
    private int stockReal;
    private int stockReceta;
    private String descripcion;
    @ManyToMany(mappedBy = "medicamentosList")
    @JsonIgnore
    private List<Receta> medicamento_receta;


}
