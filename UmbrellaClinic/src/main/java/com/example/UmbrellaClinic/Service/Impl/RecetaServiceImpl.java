package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Entity.Receta;
import com.example.UmbrellaClinic.Repository.RecetaRepository;
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
        List<Medicamento> medicamentos = new ArrayList<>();
        List<Integer> cantidades = receta.getCatidadMedicamentos();

        for (int i = 0; i < receta.getMedicamentosList().size(); i++) {
            Medicamento medDesdeBD = medicamentoService.getById(receta.getMedicamentosList().get(i).getIdMedicamento());
            int cantidad = cantidades.get(i);

            int reservado = medicamentoService.reservarStock(medDesdeBD.getIdMedicamento(), cantidad);

            if (reservado == 0) {
                throw new IllegalStateException("No hay stock disponible para el medicamento: " + medDesdeBD.getNombreComercial());
            }

            medicamentos.add(medDesdeBD);
        }

        receta.setMedicamentosList(medicamentos); // Asignar lista con medicamentos que vienen desde la BD
        return recetaRepository.save(receta);
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
