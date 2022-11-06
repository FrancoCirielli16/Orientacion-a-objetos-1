package ar.edu.unlp.info.oo1.Parcial1raFecha;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unlp.info.oo1.Parcial1raFecha.Contribuyente;
import ar.edu.unlp.info.oo1.Parcial1raFecha.Embarcacion;
import ar.edu.unlp.info.oo1.Parcial1raFecha.Sistema;

class SistemaTest {
	private Sistema s;
	@BeforeEach
	void setUp() throws Exception {
		this.s = new Sistema();
	}

	@Test
	void testCalcularImpuestoDeContribuyente() {
		Contribuyente propietario = new Contribuyente ("F","1232","F@gmail.com","Argentina");
		assertEquals(0,this.s.calcularImpuestoDeContribuyente(propietario));
		Embarcacion e = this.s.darDeAltaEmbaracion("A12",LocalDate.of(2000, 10, 10),10,propietario,"F");
		assertEquals(0,this.s.calcularImpuestoDeContribuyente(propietario));
		e = this.s.darDeAltaEmbaracion("A13",LocalDate.of(2020, 10, 10),10,propietario,"F");
		assertEquals(11,this.s.calcularImpuestoDeContribuyente(propietario));
		e = this.s.darDeAltaEmbaracion("A13",LocalDate.of(2020, 10, 10),1400000,propietario,"F");
		assertEquals(1610011,this.s.calcularImpuestoDeContribuyente(propietario));
	}

}
