package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LlamadaInterUrbanaTest {
	private LlamadaInterUrbana llamada1;
	private LlamadaInterUrbana llamada2;
	private LlamadaInterUrbana llamada3;
	@BeforeEach
	void setUp() throws Exception {
		llamada1 = new LlamadaInterUrbana(LocalDateTime.of(2022, 10, 10, 20, 20),10,"","",90);
		llamada2 = new LlamadaInterUrbana(LocalDateTime.of(2022, 10, 10, 10, 10),10,"","",110);
		llamada3 = new LlamadaInterUrbana(LocalDateTime.of(2022, 10, 30, 10, 20),10,"","",550);
	}

	@Test
	void testCalcularCosto() {
		assertEquals(25,this.llamada1.calcularCosto());
		assertEquals(30,this.llamada2.calcularCosto());
		assertEquals(35,this.llamada3.calcularCosto());
	}

}
