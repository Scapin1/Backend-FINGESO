package com.example.UmbrellaClinic.Entity.Usuarios;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("rut")
    @Column(unique = true, nullable = false)
    private String rut;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("rol")
    private String rol;

    @JsonProperty("correo")
    private String correo;

    @JsonProperty("password")
    private String password;

    public String getPassword() {
        return password;
    }
}
