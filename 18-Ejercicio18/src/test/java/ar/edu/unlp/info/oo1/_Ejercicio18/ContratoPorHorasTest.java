package ar.edu.unlp.info.oo1._Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContratoPorHorasTest {
	private Empleado e1;
	private Empleado e2;
	private Empleado e3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.e1 = new Empleado("Fran","Gallardo",123231,LocalDate.of(2002, 10, 16),LocalDate.of(2022, 10, 20),false,false);
		this.e2 = new Empleado("Juan","Gallardo",143221,LocalDate.of(2002, 10, 16),LocalDate.of(2016, 11, 15),true,false);
		this.e3 = new Empleado("Pedro","Gallardo",15331,LocalDate.of(2002, 10, 16),LocalDate.of(2010, 12, 10),false,true);
	}

	@Test
	void testContratoVencido() {
		ContratoPorHoras c1 = this.e1.cargarContratoPorHoras(LocalDate.of(2022, 11, 25), LocalDate.of(2023, 11, 2), 10, 10);
		assertFalse(c1.contratoVencido());
		ContratoPorHoras c2 = this.e2.cargarContratoPorHoras(LocalDate.of(2022, 10, 25), LocalDate.of(2022, 2, 26), 10, 10);
		assertTrue(c2.contratoVencido());
		ContratoPorHoras c3 = this.e3.cargarContratoPorHoras(LocalDate.of(2021, 10, 25), LocalDate.of(2022, 10, 31), 10, 10);
		assertTrue(c3.contratoVencido());
	}
	
	@Test
	void testCalcularMonto() {
		ContratoPorHoras c1 = this.e1.cargarContratoPorHoras(LocalDate.of(2021, 10, 25), LocalDate.of(2022, 11, 2), 10, 10);
		assertEquals(100,c1.calcularMonto());

	}

}
