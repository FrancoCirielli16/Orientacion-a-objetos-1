package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaFisicaTest {
	private PersonaFisica persona;
	@BeforeEach
	void setUp() throws Exception {
		this.persona = new PersonaFisica("Franco","Nose",1212,"23123");
	}

	@Test
	void testCalcularCosto() {
		this.persona.registrarLlamadaLocal(LocalDateTime.of(2022, 10, 10, 10, 50), 10, null, null);
		this.persona.registrarLlamadaInterUrbana(LocalDateTime.of(2022, 10, 14, 10, 50), 10, null, null, 80);
		this.persona.registrarLlamadaInternacional(LocalDateTime.of(2022, 11, 11, 10, 50), 10, null, null, null, null);
		assertEquals(67.5,this.persona.calcularMonto(LocalDateTime.of(2022, 10, 10, 8, 50), LocalDateTime.of(2022, 12, 10, 20, 30)));
	}

}
