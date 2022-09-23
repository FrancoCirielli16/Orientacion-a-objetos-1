package ar.edu.unlp.info.oo1.Ejercicio9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CajaDeAhorroTest {
	private CajaDeAhorro cajaDeAhorro1;
	private CajaDeAhorro cajaDeAhorro2;
	
	@BeforeEach
	void setUp() {
		cajaDeAhorro1 = new CajaDeAhorro();
		cajaDeAhorro2 = new CajaDeAhorro();
	}
	
	@Test
	void testConstructor() {
		assertEquals(0,cajaDeAhorro1.getSaldo());
	}
	
	
	@Test
	void testExtraer() {
		this.cajaDeAhorro1.depositar(500);
		cajaDeAhorro1.extraerSaldo(450);
		assertEquals(31,cajaDeAhorro1.getSaldo());
		
	}
	
	@Test
	void testDepositar() {
		this.cajaDeAhorro1.depositar(400);
		assertEquals(392, this.cajaDeAhorro1.getSaldo());
	}
	
	@Test
	void testHacerTranferir(){
		this.cajaDeAhorro1.depositar(1000);
		cajaDeAhorro1.transferir(500, cajaDeAhorro2);
	    assertEquals(470,this.cajaDeAhorro1.getSaldo());
	    assertEquals(490,this.cajaDeAhorro2.getSaldo());
	}

}
