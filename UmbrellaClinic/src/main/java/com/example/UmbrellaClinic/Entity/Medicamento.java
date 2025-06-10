package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
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
    private String nombreMedicamento;
    private int stock;
    private String descripcion;

    @ManyToMany
    private List<Receta> recetasList;

    @ManyToOne
    @JoinColumn(name = "Id_quimicoFarmaceutico")
    private QuimicoFarmaceutico quimicoFarmaceutico;
}
