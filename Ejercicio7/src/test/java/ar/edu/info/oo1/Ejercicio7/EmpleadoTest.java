package ar.edu.info.oo1.Ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	private Empleado empleadoUno;
	
	
	@BeforeEach
	public void setUp()throws Exception{
		this.empleadoUno = new Empleado();
		
	}
	
	@Test
	public void testMontoBasico() {
		assertEquals(35000, empleadoUno.montoBasico());
	}
	
	@Test
	public void testAportes() {
		assertEquals(13500, empleadoUno.aportes());
	}
	
	@Test
	public void testSueloBasico() {
		assertEquals(48500, empleadoUno.sueldoBasico());
	}
	
	
	
	
	
	
}
