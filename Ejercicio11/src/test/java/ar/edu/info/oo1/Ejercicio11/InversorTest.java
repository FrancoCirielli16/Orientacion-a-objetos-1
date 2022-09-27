package ar.edu.info.oo1.Ejercicio11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	private Inversor inversor;
	private PlazoFijo plazoFijo1;
	private PlazoFijo plazoFijo2;
	private InversionEnAcciones accion1;
	private InversionEnAcciones accion2;
	
	@BeforeEach
	public void setUp() {
		this.plazoFijo1 = new PlazoFijo(LocalDate.of(2022,9,25),100,10);//3 // 2100
		this.plazoFijo2 = new PlazoFijo(LocalDate.of(2022,8,30),500,10);//28 //140500
		this.accion1 = new InversionEnAcciones("NOSE",10,100);
		this.accion2 = new InversionEnAcciones("ESON",15,100);//2500
		this.inversor = new Inversor("Franco");
	}
	
	
	@Test
	public void testValorActual() {
		assertEquals(0, this.inversor.valorActual());
		this.inversor.cargarInversion(this.plazoFijo1);
		this.inversor.cargarInversion(this.plazoFijo2);
		this.inversor.cargarInversion(this.accion1);
		this.inversor.cargarInversion(this.accion2);
		assertEquals(145100,this.inversor.valorActual(),1);
	}
}
