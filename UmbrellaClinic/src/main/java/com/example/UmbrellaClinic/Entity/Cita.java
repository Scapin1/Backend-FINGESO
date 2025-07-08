package com.example.UmbrellaClinic.Entity;

import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCita;
    private Date fechaCita;
    private String Sucursal;
    private LocalTime HoraCita;
    private Boolean eliminada = false; //ESTE BOOL CAMBIA CUANDO LA CITA ES ELIMINADA POR EL PACIENTE O MEDICO

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private Boolean agendaPaciente = true; //ESTE BOOL CAMBIA CUANDO EL PACIENTE LLEGA A LA CITA Y LA SECRETARIA
    // CONFIRMA SU LLEGADA O EN SU DEFECTO CUANDO EXPIRA EL PLAZO PARA LLEGAR
    private Boolean agendaMedico = true;//ESTE BOOL CAMBIA CUANDO EL MEDICO YA REVISO AL PACIENTE
    //PODRIA DARSE AL MEDICO LA OPCION DE CAMBIAR ESTE VALOR CON UN BOTON O Q SE HAGA AUTOMATICO AL GENERAR LA RECETA

    private Boolean disponible = true;

}
