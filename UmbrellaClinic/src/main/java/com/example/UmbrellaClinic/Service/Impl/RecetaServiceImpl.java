package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.HistorialMedico;
import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Entity.Usuarios.Paciente;
import com.example.UmbrellaClinic.Repository.RecetaRepository;
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

    @Override
    public List<Receta> findAll() {
        return recetaRepository.findAll();
    }

    @Override
    public Receta getById(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }


    @Transactional
    public Receta createReceta(Receta receta) {
        // Obtener paciente de BD o lanzar excepción si no existe
        Paciente paciente = pacienteRepository.findById(receta.getPaciente().getId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // Obtener historial médico del paciente
        HistorialMedico historial = paciente.getHistorialMedico();

        List<Medicamento> medicamentos = new ArrayList<>();
        List<Integer> cantidades = receta.getCantidadMedicamentos();
        List<Medicamento> sinStock = new ArrayList<>();
        List<Integer> cantidadesGuardar = new ArrayList<>();

        // Validar stock y reservar medicamentos
        for (int i = 0; i < receta.getMedicamentosList().size(); i++) {
            Medicamento medDesdeBD = medicamentoService.getById(receta.getMedicamentosList().get(i).getIdMedicamento());
            int cantidad = cantidades.get(i);
            int reservado = medicamentoService.reservarStock(medDesdeBD.getIdMedicamento(), cantidad);

            if (reservado == 0) {
                cantidadesGuardar.add(0);
                sinStock.add(medDesdeBD);
            } else {
                cantidadesGuardar.add(cantidad);
                medicamentos.add(medDesdeBD);
            }
        }

        // Asociar historial médico y paciente a la receta
        receta.setHistorialMedico(historial);
        receta.setPaciente(paciente);

        if (!sinStock.isEmpty()) {
            receta.setMedicamentosSinStock(sinStock);

            if (receta.getReservarSinSock()) {
                // Solo actualiza el stock de los medicamentos que sí tienen stock suficiente
                medicamentoService.actualizarStock(medicamentos, cantidadesGuardar);
                receta.setCantidadMedicamentos(cantidadesGuardar);
                Receta recetaGuardada = recetaRepository.save(receta);
                // Agregar receta al historial médico y guardar paciente
                historial.getRecetas().add(recetaGuardada);
                pacienteRepository.save(paciente);
                return recetaGuardada;
            } else {
                return receta;
            }
        }

        // Actualiza stock y guarda receta
        medicamentoService.actualizarStock(medicamentos, cantidadesGuardar);
        Receta recetaGuardada = recetaRepository.save(receta);

        // Agregar receta al historial médico y guardar paciente
        historial.getRecetas().add(recetaGuardada);
        pacienteRepository.save(paciente);

        return recetaGuardada;
    }

    @Override
    public void entregarReceta(Long id_receta){
        Receta receta = getById(id_receta);
        receta.setEstado(true);
        List<Medicamento> medicamentos = receta.getMedicamentosList();
        List<Integer> cantidades = receta.getCantidadMedicamentos();
        for (int i = 0; i < receta.getMedicamentosList().size(); i++) {
            String nombreComercial = receta.getMedicamentosList().get(i).getNombreComercial();
            int cantidad = cantidades.get(i);
            medicamentoService.entregarMedicamentos(nombreComercial, cantidad);
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
