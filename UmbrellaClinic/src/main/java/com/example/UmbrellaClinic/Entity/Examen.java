package com.example.UmbrellaClinic.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idExamen;
    private String tipo;
    private Date fechaExamen;

}
