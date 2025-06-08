package com.example.UmbrellaClinic.Entity.Usuarios;

import com.example.UmbrellaClinic.Entity.Cita;
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
public class Paciente extends Usuario {
    private Date fechaNacimiento;



    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private List<Cita> citasList;
}
