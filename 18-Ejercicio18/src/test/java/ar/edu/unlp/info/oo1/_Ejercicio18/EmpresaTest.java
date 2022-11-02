package ar.edu.unlp.info.oo1._Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {
	private Empresa empresa;
	@BeforeEach
	void setUp() throws Exception {
		this.empresa = new Empresa();
	}

	@Test
	void testDarAltaEmpleado() {
		Empleado empleado = this.empresa.darAltaEmpleado("Franco", "Cirielli", 32121,LocalDate.of(2002, 10, 10), LocalDate.of(2022, 11, 10), false, false);
		assertNotNull(empleado);
	}
	
	@Test
	void testDarBajaEmpleado() {
		this.empresa.darAltaEmpleado("Franco", "Cirielli", 32121,LocalDate.of(2002, 10, 10), LocalDate.of(2022, 10, 3), false, false);
		this.empresa.darAltaEmpleado("Franco", "Cirielli", 32121,LocalDate.of(2002, 10, 10), LocalDate.of(2022, 11, 15), false, false);
		Empleado empleado = this.empresa.darAltaEmpleado("Franco", "Cirielli", 32121,LocalDate.of(2002, 10, 10), LocalDate.of(2022, 12, 28), false, false);
		assertTrue(this.empresa.darBajaEmpleado(empleado));
		assertFalse(this.empresa.darBajaEmpleado(empleado));
	}
	
	@Test
	void testBuscarEmpleado() {
		assertNull(this.empresa.buscarEmpleado(34241));
		Empleado empleado = this.empresa.darAltaEmpleado("Franco", "Cirielli", 32121,LocalDate.of(2002, 10, 10), LocalDate.of(2022, 12, 28), false, false);
		assertEquals(empleado,this.empresa.buscarEmpleado(32121));
		
	}
	
	@Test
	void testObtenerEmpleadosConContratoVencido() {
		assertEquals(0,this.empresa.obtenerEmpleadosConContratoVencido().size());
		Empleado empleado = this.empresa.darAltaEmpleado("Franco", "Cirielli", 32121,LocalDate.of(2002, 10, 10), LocalDate.of(2022, 10, 3), false, false);
		empleado.cargarContratoPorHoras(LocalDate.of(2022, 10, 10),LocalDate.of(2023, 10, 10), 0, 0);
		empleado = this.empresa.darAltaEmpleado("Franco", "Cirielli", 31212,LocalDate.of(2002, 9, 10), LocalDate.of(2022, 10, 15), false, false);
		empleado.cargarContratoPorHoras(LocalDate.of(2022, 9, 15), LocalDate.of(2022, 10, 15), 0, 0);
		empleado = this.empresa.darAltaEmpleado("Franco","daada", 0, LocalDate.of(2002,3,15),LocalDate.of(2022,11,15), false, false);
		empleado.cargarContratoDePlanta(LocalDate.of(2022,11,15), 0, 0, 0);
		assertEquals(1,this.empresa.obtenerEmpleadosConContratoVencido().size());
	}	
		@Test
	void testGenerarRecibo() {
			assertEquals(0,this.empresa.generarRecibos().size());
			Empleado empleado = this.empresa.darAltaEmpleado("Franco", "Cirielli", 32121,LocalDate.of(2002, 10, 10), LocalDate.of(2022, 10, 3), false, false);
			empleado.cargarContratoPorHoras(LocalDate.of(2022, 10, 10),LocalDate.of(2023, 10, 10), 0, 0);
			empleado = this.empresa.darAltaEmpleado("Franco", "Cirielli", 31212,LocalDate.of(2002, 9, 10), LocalDate.of(2022, 10, 15), false, false);
			empleado.cargarContratoPorHoras(LocalDate.of(2022, 9, 15), LocalDate.of(2022, 10, 15), 0, 0);
			empleado = this.empresa.darAltaEmpleado("Franco","daada", 0, LocalDate.of(2002,3,15),LocalDate.of(2022,11,15), false, false);
			empleado.cargarContratoDePlanta(LocalDate.of(2022,11,15), 0, 0, 0);
			assertEquals(3,this.empresa.generarRecibos().size());
		}

}
