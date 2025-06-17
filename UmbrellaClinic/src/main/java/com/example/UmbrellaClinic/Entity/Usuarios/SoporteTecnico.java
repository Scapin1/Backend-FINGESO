package com.example.UmbrellaClinic.Entity.Usuarios;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Entity
public class SoporteTecnico extends Usuario {
}
