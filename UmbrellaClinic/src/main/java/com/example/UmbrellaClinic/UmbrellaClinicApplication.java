package com.example.UmbrellaClinic;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Entity.Sucursal;
import com.example.UmbrellaClinic.Entity.Usuarios.SoporteTecnico;
import com.example.UmbrellaClinic.Repository.MedicamentoRepository;
import com.example.UmbrellaClinic.Repository.SucursalRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.SoporteTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UmbrellaClinicApplication{

	public static void main(String[] args) {
		SpringApplication.run(UmbrellaClinicApplication.class, args);
	}

}
