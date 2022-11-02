package ar.edu.unlp.info.oo1._Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTest {
	private Empleado e1;
	private Empleado e2;
	private Empleado e3;
	private Empleado e4;
	@BeforeEach
	void setUp() throws Exception {
		this.e1 = new Empleado("Fran","Gallardo",123231,LocalDate.of(2002, 10, 16),LocalDate.of(2022, 10, 20),false,false);
		this.e2 = new Empleado("Juan","Gallardo",143221,LocalDate.of(2002, 10, 16),LocalDate.of(2016, 1, 15),true,false);
		this.e3 = new Empleado("Pedro","Gallardo",15331,LocalDate.of(2002, 10, 16),LocalDate.of(2010, 12, 10),false,true);
		this.e4 = new Empleado("Lucas","Gallardo",441321,LocalDate.of(2002, 10, 16),LocalDate.of(2000, 1, 1),true,true);
	}

	@Test
	void testCargarContratoDePlanta() {
		ContratoDePlanta contrato = this.e1.cargarContratoDePlanta(LocalDate.of(2022, 10, 21), 0, 0, 0);
		assertNotNull(contrato);
		contrato = this.e1.cargarContratoDePlanta(null, 0, 0, 0);
		assertNull(contrato);
	}
	
	@Test
	void testCargarContratoPorHoras() {
		ContratoPorHoras contrato = this.e1.cargarContratoPorHoras(LocalDate.of(2022, 11, 20),LocalDate.of(2022, 12, 20) , 0, 0);
		assertNotNull(contrato);
		contrato = this.e1.cargarContratoPorHoras(LocalDate.of(2022, 10, 20), LocalDate.of(2022, 10, 20), 0, 0);
		assertNull(contrato);
		//Preguntar a practicante
		contrato = this.e2.cargarContratoPorHoras(LocalDate.of(2022, 10, 4), LocalDate.of(2022, 10, 20), 0, 0); //Si la fecha de inicio esta despues de la Fecha actual
		assertNull(contrato); //esto es correcto -----> pero si hago esto nunca voy a poder agregar una contrato con fecha de inicio antes que la fecha actual para testear los contratos vencidos en el testTieneContratoVencido
		//osea me obliga a carga contratos con fecha de inicio posterior a la actual
		//mirar metodo CargarContratoPorHoras el if comentado
		contrato = this.e2.cargarContratoPorHoras(LocalDate.of(2022, 11, 20), LocalDate.of(2022, 10, 20), 0, 0);
		assertNotNull(contrato);
	}
	
	@Test
	void testTieneContratoVencido() {
		assertTrue(this.e1.tieneContratoVencido());
		this.e1.cargarContratoPorHoras(LocalDate.of(2022, 12, 4),LocalDate.of(2023, 10, 4), 0, 0);
		assertFalse(this.e1.tieneContratoVencido());
		this.e2.cargarContratoDePlanta(LocalDate.of(2022, 12, 1), 0, 0, 0);
		assertFalse(this.e2.tieneContratoVencido());
		this.e3.cargarContratoPorHoras(LocalDate.of(2022, 5, 4),LocalDate.of(2022, 10, 4), 0, 0);
		assertTrue(this.e3.tieneContratoVencido());
	}
	
	@Test
	void testGenerarRecibo() {
	}
	
	@Test
	void testAntiguedad() {
		assertEquals(0,this.e1.antiguedad());
		assertEquals(6,this.e2.antiguedad());
		assertEquals(11,this.e3.antiguedad());
		assertEquals(22,this.e4.antiguedad());
	}
	
	@Test
	void testCalcularAumento() {
		assertEquals(0,this.e1.calcularAumento());
		assertEquals(0.3,this.e2.calcularAumento());
		assertEquals(0.5,this.e3.calcularAumento());
		assertEquals(1,this.e4.calcularAumento());
	}
	
	@Test
	void testEsEmpleado() {
		assertTrue(this.e1.esEmpleado(123231));
		assertFalse(this.e1.esEmpleado(143221));
	}

}
