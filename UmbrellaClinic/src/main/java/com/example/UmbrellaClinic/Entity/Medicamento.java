package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.QuimicoFarmaceutico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Medicamento {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long idMedicamento;
    private String nombreComercial;
    private String principioActivo;
    private String tipoMedicamento;
    private int stockReal;
    private int stockReceta=0;
    private String descripcion;


    //no es parte de lo que debe tener un medicamento ya que es una relacion
    @ManyToMany(mappedBy = "medicamentosList")
    @JsonIgnore
    private List<Receta> medicamento_receta;
    private String gramageMl;
    private String laboratorio;

}
