package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	private Propiedad P1;
	private Usuario inquilino1;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private Reserva R1,R2;
	@BeforeEach
	void setUp() throws Exception {
		this.P1 = new Propiedad("X","X","C",200);
		this.inquilino1 = new Usuario("Franco","P",1223);
		this.periodo1 = new DateLapse(LocalDate.of(2022, 10, 20),LocalDate.of(2022, 10, 25));
		this.periodo2 = new DateLapse(LocalDate.of(2022, 11, 20),LocalDate.of(2022, 11, 25));
		this.R1 = new Reserva(periodo1,inquilino1,P1);
		this.R2 = new Reserva(periodo2,inquilino1,P1);
	}

	@Test
	void testCalcularPrecio() {
		assertEquals(1000,this.R1.calcularPrecio(this.periodo1));
	}
	
	@Test
	void testValidarFecha() {
		assertFalse(this.R1.validarFecha());
		assertTrue(this.R2.validarFecha());
	}
	
	@Test
	void testValidadPeriodo() {
		assertTrue(this.R1.seSuperpone(periodo1));
		assertFalse(this.R1.seSuperpone(periodo2));
	}	
	
	@Test
	void testEsUsuario() {
		Usuario inquilino2 = new Usuario("Pepe","X",123213);
		assertTrue(this.R1.esUsuario(inquilino1));
		assertFalse(this.R1.esUsuario(inquilino2));
	}
}
