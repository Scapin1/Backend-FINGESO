package com.example.UmbrellaClinic.Entity.Usuarios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente extends Usuario {
    private Date fechaNacimiento;
}
