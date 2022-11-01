package ar.edu.unlp.info.oo1._Ejercicio18;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContratoDePlantaTest {
	private Empleado e1;
	private Empleado e2;
	private Empleado e3;
	private Empleado e4;
	@BeforeEach
	void setUp() throws Exception {
		this.e1 = new Empleado("Fran","Gallardo",123231,LocalDate.of(2002, 10, 16),LocalDate.of(2022, 10, 20),false,false);
		this.e2 = new Empleado("Juan","Gallardo",143221,LocalDate.of(2002, 10, 16),LocalDate.of(2016, 11, 15),true,false);
		this.e3 = new Empleado("Pedro","Gallardo",15331,LocalDate.of(2002, 10, 16),LocalDate.of(2010, 12, 10),false,true);
		this.e4 = new Empleado("Lucas","Gallardo",441321,LocalDate.of(2002, 10, 16),LocalDate.of(2005, 1, 1),true,true);

	}
	
	@Test
	void testCalcularMonto() {
		this.e1.cargarContratoDePlanta(LocalDate.of(2022, 10, 20), 100, 200, 1000);
		this.e2.cargarContratoDePlanta(LocalDate.of(2016, 11, 15), 100, 200, 1000);
		this.e3.cargarContratoDePlanta(LocalDate.of(2010, 12, 10), 100, 200, 1000);
		this.e4.cargarContratoDePlanta(LocalDate.of(2005, 1, 1), 100, 200, 1000);
		assertEquals(100,this.e1.calcularMonto());
		assertEquals(300,this.e2.calcularMonto());
		assertEquals(1100,this.e3.calcularMonto());
		assertEquals(1300,this.e4.calcularMonto());

		

	}
}