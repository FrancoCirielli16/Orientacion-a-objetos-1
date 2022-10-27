package ar.edu.unlp.info.oo1.Ejercicio16;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaTest {
	private Propiedad P1,P2,P3;
	private Usuario inquilino1;
	private DateLapse periodo1;
	private DateLapse periodo2;
	private Reserva R1,R2;
	private Politica estricta,flexible,moderada;

	@BeforeEach
	void setUp() throws Exception {
		this.estricta = new PoliticaEstricta();
		this.flexible = new PoliticaFlexible();
		this.moderada = new PoliticaModerada();
		this.P1 = new Propiedad("X","X","C",flexible,200);
		this.P2 = new Propiedad("X","X","C",moderada,100);
		this.P3 = new Propiedad("X","X","C",estricta,100);
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
	
	@Test
	void testCalcularRembolso(){
		//politica flexible
		LocalDate fechaDeCancelacion = LocalDate.of(2022, 10, 10);
		Reserva R3 = this.P1.hacerReserva(periodo1, inquilino1);
		assertEquals(1000,R3.calcularRembolso(fechaDeCancelacion));
		fechaDeCancelacion = LocalDate.of(2022, 11, 23);
		assertEquals(0,R3.calcularRembolso(fechaDeCancelacion));
		//politica moderada
		fechaDeCancelacion = LocalDate.of(2022, 10, 20);
		Reserva R4 = this.P2.hacerReserva(periodo2, inquilino1);
		assertEquals(500,R4.calcularRembolso(fechaDeCancelacion));
		fechaDeCancelacion = LocalDate.of(2022, 11, 20);
		assertEquals(250,R4.calcularRembolso(fechaDeCancelacion));
		//politica estricta
		fechaDeCancelacion = LocalDate.of(2022, 11, 10);
		Reserva R5 = this.P3.hacerReserva(periodo2, inquilino1);
		assertEquals(0,R5.calcularRembolso(fechaDeCancelacion));
	}
}
