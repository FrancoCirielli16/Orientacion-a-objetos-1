package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaInternacionalTest {
	private LlamadaInternacional llamada1;
	private LlamadaInternacional llamada2;
	@BeforeEach
	void setUp() throws Exception {
		this.llamada1 = new LlamadaInternacional(LocalDateTime.of(2022, 10, 5, 21, 40),10,"","","","");
		this.llamada2 = new LlamadaInternacional(LocalDateTime.of(2022, 1, 10, 8, 50),10,"","","","");
	}

	@Test
	void testCalcularCosto() {
		assertEquals(30,this.llamada1.calcularCosto());
		assertEquals(40,this.llamada2.calcularCosto());
	}

}
