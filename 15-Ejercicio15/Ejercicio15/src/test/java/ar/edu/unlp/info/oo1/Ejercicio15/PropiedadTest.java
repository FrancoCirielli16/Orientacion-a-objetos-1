package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropiedadTest {
	private Propiedad P1;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private DateLapse periodo3;
	private DateLapse periodo4;
	private Usuario inquilino1;
	private Usuario inquilino2;
	private Usuario inquilino3;
	private Usuario inquilino4;
	@BeforeEach
	void setUp() throws Exception {
		this.P1 = new Propiedad("x","x","x",100);
		this.periodo1 = new DateLapse(LocalDate.of(2022, 10, 20),LocalDate.of(2022, 10, 25));
		this.periodo2 = new DateLapse(LocalDate.of(2022, 4, 10),LocalDate.of(2022, 4, 15));
		this.periodo3 = new DateLapse(LocalDate.of(2022, 10, 24),LocalDate.of(2022, 10, 30));
		this.periodo4 = new DateLapse(LocalDate.of(2022, 11, 5),LocalDate.of(2022, 11, 10));
		this.inquilino1 = new Usuario("Pepe","12",143234);
		this.inquilino2 = new Usuario("jose","13",245234);
		this.inquilino3 = new Usuario("Maria","43",354423);
		this.inquilino4 = new Usuario("Fran","51",432423);
	}

	@Test
	void testHacerReserva() {
		
		assertNotNull(P1.hacerReserva(periodo1, inquilino1));
		assertNotNull(P1.hacerReserva(periodo2, inquilino1));
		assertNull(P1.hacerReserva(periodo3, inquilino3));
		assertNull(P1.hacerReserva(periodo1, inquilino2));
	}
	
	@Test
	void testEliminarReserva() {
		Reserva R3 = new Reserva(periodo1,inquilino1,P1);
		assertFalse(P1.eliminarReserva(R3));
		Reserva R1 = P1.hacerReserva(periodo1, inquilino3);
		Reserva R4 = P1.hacerReserva(periodo4, inquilino4);
		assertFalse(P1.eliminarReserva(R1));
		assertTrue(P1.eliminarReserva(R4));
	}
	
	@Test
	void testValidarPropiedad() {
	
	}
	
	@Test
	void testDevolverReserva() {
		
	}
	
	@Test
	void testCalcularIngreso() {
		DateLapse periodoX = new DateLapse(LocalDate.of(2021, 10, 10), LocalDate.of(2023, 11, 7)); 
		this.P1.hacerReserva(periodo1, inquilino1);
		this.P1.hacerReserva(periodo2, inquilino1);
		this.P1.hacerReserva(periodo3, inquilino1);
		this.P1.hacerReserva(periodo4, inquilino1);
		assertEquals(1500,this.P1.calcularIngreso(periodoX));
		periodoX = new DateLapse(LocalDate.of(2023, 10, 10), LocalDate.of(2023, 11, 7));
		assertEquals(0,this.P1.calcularIngreso(periodoX));
		periodoX = new DateLapse(LocalDate.of(2022, 10, 23), LocalDate.of(2022, 11, 7));
		assertEquals(400,this.P1.calcularIngreso(periodoX));

		
	}

}
