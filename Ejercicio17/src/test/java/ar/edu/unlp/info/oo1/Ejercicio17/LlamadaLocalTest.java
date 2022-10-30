package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaLocalTest {
	private LlamadaLocal llamada;
	@BeforeEach
	void setUp() throws Exception {
		llamada = new LlamadaLocal(LocalDateTime.of(2022, 10, 20, 10, 10),10,"123123","12312");
	}

	@Test
	void testCalcularCosto() {
		assertEquals(10,this.llamada.calcularCosto());
	}

}
