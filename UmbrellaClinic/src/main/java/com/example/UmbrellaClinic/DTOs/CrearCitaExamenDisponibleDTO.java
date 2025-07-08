package com.example.UmbrellaClinic.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter

public class CrearCitaExamenDisponibleDTO {
    private Long idEnfermero;
    private Date fecha;
    private LocalTime hora;
    private String sucursal;
}
