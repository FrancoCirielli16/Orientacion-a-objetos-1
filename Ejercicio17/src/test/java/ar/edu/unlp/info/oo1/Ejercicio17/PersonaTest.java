package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTest {
	private PersonaFisica persona1;
	private PersonaJuridica persona2;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	@BeforeEach
	void setUp() throws Exception {
		this.fechaInicio = LocalDateTime.of(2022, 10, 5, 23, 1);
		this.fechaFin = LocalDateTime.of(2022, 12, 10, 22, 10);
		this.persona1 = new PersonaFisica("F","x",12312,"123131");
		this.persona2 = new PersonaJuridica("F","x",12312,"Empresa","21323");		
	}

	@Test
	void testFacturar() {
		Factura factura = persona1.facturar(fechaInicio, fechaFin);
		assertNotNull(factura);
	}

	@Test
	void testCalcularMonto() {
		//Local
		this.persona1.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 15, 11, 30), 100, null,null);//100
		//InterUrbana
		this.persona1.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 15, 10), 10, null, null, 40);//25
		this.persona1.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 16, 2), 15, null, null, 110);//42,5
		this.persona1.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 17, 30), 20, null, null, 600);//65
		//Internacional
		this.persona1.registrarLlamadaInternacional(LocalDateTime.of(2022, 10, 10, 21, 30),20, null, null, null, null);//60
		this.persona1.registrarLlamadaInternacional(LocalDateTime.of(2022, 11, 15, 8, 30),25, null, null, null, null);//100
		assertEquals(353.25,this.persona1.calcularMonto(fechaInicio, fechaFin));
	}
	
	@Test
	void testRegistrarLlamadaLocal() {
		LlamadaLocal llamadaLocal = this.persona1.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 15, 11, 30), 100, null,null);
		assertNotNull(llamadaLocal);

	}
	
	@Test
	void testRegistrarLlamadaInternacional() {
		LlamadaInternacional llamadaI = this.persona1.registrarLlamadaInternacional(LocalDateTime.of(2022, 10, 10, 21, 30),20, null, null, null, null);
		assertNotNull(llamadaI);
	}
	
	@Test
	void testRegistrarLlamadaInterUrbana() {
		LlamadaInterUrbana llamadaIU = this.persona1.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 11, 20, 15, 10), 10, null, null, 40);
		assertNotNull(llamadaIU);
	}
}
