package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.CitaExamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaExamenRepository extends JpaRepository<CitaExamen, Long> {
    @Query("""
        SELECT c FROM CitaExamen c
        WHERE (c.paciente.id = :userId OR c.enfermero.id = :userId)
          AND c.eliminada = FALSE
          AND c.agendaPaciente = TRUE
          AND c.agendaEnfermero = TRUE
    """)
    List<CitaExamen> findCitasPendientesByUserId(@Param("userId") Long userId);

    @Query("""
        SELECT c FROM CitaExamen c
        WHERE c.disponible = true
          AND c.eliminada = false
          AND c.enfermero.id = :idEnfermero
    """)
    List<CitaExamen> findDisponiblesByEnfermeroId(@Param("idEnfermero") Long idEnfermero);
}
