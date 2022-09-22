package ar.edu.info.oo1.Ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GerenteTest {
	private Gerente gerenteUno;
	
	@BeforeEach
	public void setUp(){
		this.gerenteUno = new Gerente();
	}
	
	@Test 
	public void testAporte() {
		assertEquals(2850,this.gerenteUno.aportes());
	}

	@Test 
	public void testMontoBasico() {
		assertEquals(57000,this.gerenteUno.montoBasico());
	}

	
}
