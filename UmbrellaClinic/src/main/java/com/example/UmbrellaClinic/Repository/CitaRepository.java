package com.example.UmbrellaClinic.Repository;

import com.example.UmbrellaClinic.Entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {
    @Query("""
      SELECT c
        FROM Cita c
       WHERE (c.paciente.id   = :userId
              OR c.medico.id  = :userId)
         AND c.eliminada       = FALSE
         AND c.agendaPaciente  = TRUE
         AND c.agendaMedico    = TRUE
    """)
    List<Cita> findCitasPendientesByUserId(@Param("userId") Long userId);

    @Query("""
    SELECT c FROM Cita c
    WHERE c.disponible = true
      AND c.eliminada = false
      AND c.medico.id = :idMedico
""")
    List<Cita> findDisponiblesByMedicoId(@Param("idMedico") Long idMedico);
}
