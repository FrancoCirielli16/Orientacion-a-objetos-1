package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
	private Usuario U1,U2;
	private DateLapse periodo1,periodo2,periodo3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.U1 = new Usuario("Juan","43 Y 5",44531);
		this.U2 = new Usuario("Fran","48 Y 10",46621);
		this.periodo1 = new DateLapse(LocalDate.of(2022, 5, 10),LocalDate.of(2022, 5, 20));
		this.periodo2 = new DateLapse(LocalDate.of(2022, 10, 21),LocalDate.of(2022, 10, 30));
		this.periodo3 = new DateLapse(LocalDate.of(2022, 12, 10),LocalDate.of(2022, 12, 16));
	}

	@Test 
	void buscarPropiedades() {
		DateLapse periodoX = new DateLapse(LocalDate.of(2024, 10, 10),LocalDate.of(2024, 10, 20));
		assertEquals(0,this.U1.buscarPropiedades(periodoX).size());
		Propiedad P1 = this.U1.registrarPropiedad("F", "null", "null", 100);
		P1.hacerReserva(periodo1, U1);
		P1.hacerReserva(periodo3, U1);
		Propiedad P2 = this.U1.registrarPropiedad("G", "null", "null", 100);
		P2.hacerReserva(periodo2, U1);
		Propiedad P3 = this.U1.registrarPropiedad("M", "null", "null", 100);
		P3.hacerReserva(periodo3, U1);
		periodoX = new DateLapse(LocalDate.of(2022, 10, 10),LocalDate.of(2022, 11, 10));
		assertEquals(2,this.U1.buscarPropiedades(periodoX).size());
		
		
	}
	
	@Test
	void testRegistrarPropiedad() {
		assertEquals(0,this.U1.getSize());
		this.U1.registrarPropiedad("F", "X", "X", 100);
		this.U1.registrarPropiedad("D", "X", "X", 1000);
		this.U1.registrarPropiedad("S", "X", "X", 1000);
		this.U1.registrarPropiedad("A", "X", "X", 200);
		assertEquals(4,this.U1.getSize());
	}
	
	
	@Test
	void testCalcularIngreso() {
		Propiedad P1 = this.U1.registrarPropiedad("F", "null", "null", 100);
		P1.hacerReserva(periodo1, U1);
		P1.hacerReserva(periodo2, U2);
		P1.hacerReserva(periodo3, U1);
		DateLapse periodoX = new DateLapse(LocalDate.of(2024, 10, 10),LocalDate.of(2024, 10, 20));
		assertEquals(0,this.U1.calcularIngreso(periodoX));
		periodoX = new DateLapse(LocalDate.of(2022, 5, 10),LocalDate.of(2022, 12, 17));
		assertEquals(2500,this.U1.calcularIngreso(periodoX));
		periodoX = new DateLapse(LocalDate.of(2022, 10, 22),LocalDate.of(2022, 12, 11));
		assertEquals(900,this.U1.calcularIngreso(periodoX));
	}
	
	
	@Test
	void testObtenerReserva() {
		assertEquals(0,this.U1.ObtenerReserva(U1).size());
		Propiedad P1 = this.U1.registrarPropiedad("F", "null", "null", 100);
		P1.hacerReserva(periodo1, U1);
		P1.hacerReserva(periodo3, U2);
		Propiedad P2 = this.U1.registrarPropiedad("G", "null", "null", 100);
		P2.hacerReserva(periodo2, U1);
		Propiedad P3 = this.U1.registrarPropiedad("M", "null", "null", 100);
		P3.hacerReserva(periodo3, U1);
		assertEquals(1,this.U1.ObtenerReserva(U2).size());
		assertEquals(3,this.U1.ObtenerReserva(U1).size());
		
	}

}
