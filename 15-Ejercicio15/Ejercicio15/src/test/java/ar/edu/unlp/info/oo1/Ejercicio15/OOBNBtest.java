package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OOBNBtest {
	private OOBNB  booking = new OOBNB();
	private DateLapse periodo1,periodo2,periodo3;
	@BeforeEach
	void setUp() throws Exception {
		this.booking = new OOBNB();	
		this.periodo1 = new DateLapse(LocalDate.of(2022, 5, 10),LocalDate.of(2022, 5, 20));
		this.periodo2 = new DateLapse(LocalDate.of(2022, 10, 21),LocalDate.of(2022, 10, 30));
		this.periodo3 = new DateLapse(LocalDate.of(2022, 12, 10),LocalDate.of(2022, 12, 16));
	}

	@Test
	void testRegistrarUsuario() {
		assertNotNull(this.booking.registrarUsuario("F", "F", 100));
	}
	
	@Test
	void testBuscarPropiedades() {
		DateLapse periodoX = new DateLapse(LocalDate.of(2024, 10, 10),LocalDate.of(2024, 10, 20));
		assertEquals(0,this.booking.buscarPropiedades(periodoX).size());
		Usuario U1 = this.booking.registrarUsuario("Franco", "C", 12341);
		Propiedad P1 = U1.registrarPropiedad("F", "null", "null", 100);
		P1.hacerReserva(periodo1, U1);
		P1.hacerReserva(periodo3, U1);
		Propiedad P2 = U1.registrarPropiedad("G", "null", "null", 100);
		P2.hacerReserva(periodo2, U1);
		Propiedad P3 = U1.registrarPropiedad("M", "null", "null", 100);
		P3.hacerReserva(periodo3, U1);
		periodoX = new DateLapse(LocalDate.of(2022, 10, 10),LocalDate.of(2022, 11, 10));
		assertEquals(2,this.booking.buscarPropiedades(periodoX).size());
		
	}
	
	@Test
	void testObtenerReserva() {
		Usuario U1 = this.booking.registrarUsuario("Franco", "C", 12341);
		Propiedad P1 = U1.registrarPropiedad("F", "null", "null", 100);
		assertEquals(0,this.booking.obtenerReserva(U1).size());
		P1.hacerReserva(periodo1, U1);
		P1.hacerReserva(periodo2, U1);
		P1.hacerReserva(periodo3, U1);
		assertEquals(3,this.booking.obtenerReserva(U1).size());
	}
	
	@Test
	void testCalcularIngresoPropietario() {
		DateLapse periodoX = new DateLapse(LocalDate.of(2022, 10, 10),LocalDate.of(2024, 10, 20));
		Usuario U1 = this.booking.registrarUsuario("Franco", "C", 12341);
		Propiedad P1 = U1.registrarPropiedad("F", "null", "null", 100);
		P1.hacerReserva(periodo1, U1);
		P1.hacerReserva(periodo2, U1);
		P1.hacerReserva(periodo3, U1);
		assertEquals(1500,this.booking.calcularIngresoDePropietario(U1, periodoX));
		periodoX = new DateLapse(LocalDate.of(2024, 10, 10),LocalDate.of(2024, 10, 20));
		assertEquals(0,this.booking.calcularIngresoDePropietario(U1, periodoX));
		periodoX = new DateLapse(LocalDate.of(2022, 10, 15),LocalDate.of(2022, 12, 15));
		assertEquals(1400,this.booking.calcularIngresoDePropietario(U1, periodoX));

	}

}
