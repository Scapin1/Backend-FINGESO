package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.Enfermero;
import com.example.UmbrellaClinic.Entity.Usuarios.Gerente;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
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
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSucursal;
    private String nombreSucursal;
    private String direccion;

    @ManyToMany(mappedBy = "sucursales")
    @JsonIgnore
    private List<Medico> medicos;

    @ManyToMany(mappedBy = "sucursales")
    @JsonIgnore
    private List<Enfermero> enfermeros;

    @ManyToMany(mappedBy = "sucursales")
    @JsonIgnore
    private List<Gerente> gerentes;
}
