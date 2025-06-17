package com.example.UmbrellaClinic;

import com.example.UmbrellaClinic.Entity.Medicamento;
import com.example.UmbrellaClinic.Entity.Usuarios.SoporteTecnico;
import com.example.UmbrellaClinic.Repository.MedicamentoRepository;
import com.example.UmbrellaClinic.Service.interfaces.Usuarios.SoporteTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UmbrellaClinicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UmbrellaClinicApplication.class, args);
	}

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Autowired
	private SoporteTecnicoService soporteTecnicoService;

	public void run(String... args) throws Exception {
		SoporteTecnico soporte1 = SoporteTecnico.builder()
				.nombre("Admin")
				.correo("Admin@umbrella.cl")
				.rut("99.999.999-9")
				.password("admin123")
				.rol("Administrador")
				.build();
		Medicamento medicamento1 = Medicamento.builder()
				.nombreComercial("Paracetamol")
				.stockReal(15)
				.descripcion("Sirve para el tratamiento de fiebre y dolor leve a moderado.")
				.tipoMedicamento("Analgésico")
				.principioActivo("Acetaminofén")
				.build();
		Medicamento medicamento2 = Medicamento.builder()
				.nombreComercial("Ibuprofeno")
				.stockReal(20)
				.descripcion("Antiinflamatorio no esteroideo (AINE) para reducir la fiebre, el dolor y la inflamación.")
				.tipoMedicamento("AINE")
				.principioActivo("Ibuprofeno")
				.build();
		Medicamento medicamento3 = Medicamento.builder()
				.nombreComercial("Amoxicilina")
				.stockReal(30)
				.descripcion("Antibiótico de amplio espectro para tratar infecciones bacterianas.")
				.tipoMedicamento("Antibiótico")
				.principioActivo("Amoxicilina")
				.build();
		Medicamento medicamento4 = Medicamento.builder()
				.nombreComercial("Loratadina")
				.stockReal(25)
				.descripcion("Antihistamínico para aliviar los síntomas de alergias.")
				.tipoMedicamento("Antihistamínico")
				.principioActivo("Loratadina")
				.build();
		Medicamento medicamento5 = Medicamento.builder()
				.nombreComercial("Omeprazol")
				.stockReal(10)
				.descripcion("Inhibidor de la bomba de protones para reducir la producción de ácido en el estómago.")
				.tipoMedicamento("Inhibidor de la bomba de protones")
				.principioActivo("Omeprazol")
				.build();
		Medicamento medicamento6 = Medicamento.builder()
				.nombreComercial("Aspirina")
				.stockReal(18)
				.descripcion("Analgésico, antipirético y antiinflamatorio.")
				.tipoMedicamento("AINE")
				.principioActivo("Ácido acetilsalicílico")
				.build();
		soporteTecnicoService.save(soporte1);
		medicamentoRepository.save(medicamento1);
		medicamentoRepository.save(medicamento2);
		medicamentoRepository.save(medicamento3);
		medicamentoRepository.save(medicamento4);
		medicamentoRepository.save(medicamento5);
		medicamentoRepository.save(medicamento6);
	}
}
