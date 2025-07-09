package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Entity.Usuarios.Medico;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.RecetaRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.MedicoRepository;
import com.example.UmbrellaClinic.Repository.Usuarios.PacienteRepository;
import com.example.UmbrellaClinic.Service.interfaces.MedicamentoService;
import com.example.UmbrellaClinic.Service.interfaces.RecetaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService {
    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private MedicamentoService medicamentoService;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public List<Receta> findAll() {
        return recetaRepository.findAll();
    }

    @Override
    public Receta getById(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }

    // cambiar para que antes de hacer una receta ya sepa el stock de medicamentos
    @Transactional
    public Receta createReceta(Receta receta) {
        Paciente paciente = obtenerPaciente(receta.getPaciente().getId());
        Medico medico = obtenerMedico(receta.getMedico().getId());
        if(medico.getRut().equals(paciente.getRut())) {
            throw new IllegalArgumentException("Un médico no puede recetarse a sí mismo.");
        }
        receta.setPaciente(paciente);
        receta.setMedico(medico);
        receta.setHistorialMedico(paciente.getHistorialMedico());

        List<Medicamento> sinStock = new ArrayList<>();
        List<Integer> cantidadesGuardar = new ArrayList<>();
        List<Medicamento> disponibles = verificarYReservarMedicamentos(
                receta.getMedicamentosList(),
                receta.getCantidadMedicamentos(),
                sinStock,
                cantidadesGuardar
        );

        if (!sinStock.isEmpty()) {
            return guardarRecetaConFaltantes(receta, disponibles, cantidadesGuardar, sinStock);
        }

        return guardarRecetaCompleta(receta, disponibles, cantidadesGuardar);
    }

    private Receta guardarRecetaCompleta(Receta receta, List<Medicamento> disponibles,
                                         List<Integer> cantidadesGuardar) {
        medicamentoService.actualizarStock(disponibles, cantidadesGuardar);
        receta.setCantidadMedicamentos(cantidadesGuardar);
        Receta recetaGuardada = recetaRepository.save(receta);
        receta.getHistorialMedico().getRecetas().add(recetaGuardada);
        pacienteRepository.save(receta.getPaciente());
        recetaGuardada.getMedico().getRecetas().add(recetaGuardada);
        medicoRepository.save(recetaGuardada.getMedico());
        return recetaGuardada;
    }

    private Receta guardarRecetaConFaltantes(Receta receta, List<Medicamento> disponibles,
                                             List<Integer> cantidadesGuardar, List<Medicamento> sinStock) {
        receta.setMedicamentosSinStock(sinStock);
        if (receta.getReservarSinSock()) {
            medicamentoService.actualizarStock(disponibles, cantidadesGuardar);
            receta.setCantidadMedicamentos(cantidadesGuardar);
            Receta recetaGuardada = recetaRepository.save(receta);
            receta.getHistorialMedico().getRecetas().add(recetaGuardada);
            pacienteRepository.save(receta.getPaciente());
            return recetaGuardada;
        }
        return receta;
    }

    private List<Medicamento> verificarYReservarMedicamentos(List<Medicamento> meds, List<Integer> cantidades,
                                                             List<Medicamento> sinStock, List<Integer> cantidadesGuardar) {
        List<Medicamento> disponibles = new ArrayList<>();
        for (int i = 0; i < meds.size(); i++) {
            Medicamento medDesdeBD = medicamentoService.getById(meds.get(i).getIdMedicamento());
            int cantidad = cantidades.get(i);
            int reservado = medicamentoService.reservarStock(medDesdeBD.getIdMedicamento(), cantidad);
            if (reservado == 0) {
                cantidadesGuardar.add(0);
                sinStock.add(medDesdeBD);
            } else {
                cantidadesGuardar.add(cantidad);
                disponibles.add(medDesdeBD);
            }
        }
        return disponibles;
    }

    private Paciente obtenerPaciente(Long pacienteId) {
        return pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }

    private Medico obtenerMedico(Long medicoId) {
        return medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
    }


    @Override
    public void entregarReceta(Long id_receta){
        Receta receta = getById(id_receta);
        receta.setEstado(true);
        List<Integer> cantidades = receta.getCantidadMedicamentos();
        for (int i = 0; i < receta.getMedicamentosList().size(); i++) {
            Long id = receta.getMedicamentosList().get(i).getIdMedicamento();
            int cantidad = cantidades.get(i);
            medicamentoService.entregarMedicamentos(id, cantidad);
        }
    }


    @Override
    public void deleteById(Long id) {
        recetaRepository.deleteById(id);
    }
    @Override
    public List<Receta> findByPacienteRut(String rut) { // Implementación del nuevo mé
        return recetaRepository.findByPaciente_Rut(rut);
    }

}
