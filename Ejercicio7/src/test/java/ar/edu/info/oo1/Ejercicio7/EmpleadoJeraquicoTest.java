package ar.edu.info.oo1.Ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoJeraquicoTest {
	
	private EmpleadoJerarquico empleadoJerarquicoUno;
	
	@BeforeEach
	public void setUp()throws Exception{
		this.empleadoJerarquicoUno = new EmpleadoJerarquico();
		
	}
	
	@Test
	public void testSueldoBasico() {
		assertEquals(66500, this.empleadoJerarquicoUno.sueldoBasico());
	}
	
	@Test
	public void testMontoBasico() {
		assertEquals(45000, this.empleadoJerarquicoUno.montoBasico());
	}
	
	@Test
	public void testSueloBasico() {
		assertEquals(8000, this.empleadoJerarquicoUno.bonoPorCategoria());
	}	
}
