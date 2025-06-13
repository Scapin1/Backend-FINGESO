package com.example.UmbrellaClinic.Service.Impl;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Repository.MedicamentoRepository;
import com.example.UmbrellaClinic.Service.interfaces.MedicamentoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> findAll() {
        return medicamentoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        medicamentoRepository.deleteById(id);
    }

    @Override
    public void save(Medicamento medicamento) {
        medicamentoRepository.save(medicamento);
    }

    @Override
    public Medicamento getById(Long id) {
        return medicamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));
    }
    @Override
    public Medicamento getByNombreComercial(String nombreComercial){
        return medicamentoRepository.findByNombreComercial(nombreComercial);
    }

    @Transactional
    public int reservarStock(long idMedicamento, int cantidad) {
        Optional<Medicamento> opMedicamento = medicamentoRepository.findById(idMedicamento);
        if (!opMedicamento.isPresent()) {
            return 0;
        }
        Medicamento medicamento = opMedicamento.get();
        int stockReal = medicamento.getStockReal();
        int stockReceta = medicamento.getStockReceta();
        int disponible = stockReal - stockReceta;
        if (disponible >= cantidad) {
            medicamento.setStockReceta(stockReceta + cantidad);
            return 1;
        }
        return 0;
    }

    @Transactional
    public void actualizarStockMedicamentos(String nombreComercial, int tipo, int cantidad) {
        Medicamento medicamento = getByNombreComercial(nombreComercial);
        if(tipo == 1){//tipo 1 es que va a sumar al stock q ya esta solo manipula el StockReal por ejemplo si le llegaron medicamentos
            medicamento.setStockReal(medicamento.getStockReal() + cantidad);
            return;
        }//si es de otro tipo osea 0 significa que va a actualizar el stock entero por ejemplo en controles de inventario
        medicamento.setStockReal(cantidad);
        medicamento.setStockReceta(0);
    }


}
