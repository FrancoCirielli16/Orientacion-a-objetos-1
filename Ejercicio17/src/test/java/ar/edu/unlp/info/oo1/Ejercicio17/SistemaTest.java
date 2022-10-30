package ar.edu.unlp.info.oo1.Ejercicio17;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	private Sistema movistar;
	private String nro1,nro2;
	private LocalDateTime fechaInicio,fechaFin;
	private LlamadaLocal llamadaL;
	private LlamadaInternacional llamadaI;
	private LlamadaInterUrbana llamadaIU;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.movistar = new Sistema();
		this.nro1 = "12312";
		this.nro2 = "43243";
		this.fechaInicio = LocalDateTime.of(2022, 1, 10, 20, 1);
		this.fechaFin = LocalDateTime.of(2022, 10, 20, 20, 1);
		this.llamadaI = new LlamadaInternacional(LocalDateTime.of(2022, 1, 10, 20, 1),10,"12323","321312","Argentina","Brasil");
		this.llamadaIU = new LlamadaInterUrbana(LocalDateTime.of(2022, 1, 10, 20, 1),10,"12323","321312",2);
		this.llamadaL = new LlamadaLocal(LocalDateTime.of(2022, 1, 10, 20, 1),10,"12323","321312");
	}

	@Test
	void testAgregarNro() {
		assertEquals(0,this.movistar.getListaDeNrosSize());
		this.movistar.agregarNro(nro1);
		this.movistar.agregarNro(nro2);
		assertEquals(2,this.movistar.getListaDeNrosSize());
	}
	
	@Test
	void testAgregarClienteFisico() {
		PersonaFisica persona = this.movistar.agregarClienteFisico("Franco", "Nose", 323443);
		assertNull(persona);
		this.movistar.agregarNro(nro1);
		persona = this.movistar.agregarClienteFisico("Franco", "Nose", 323443);
		assertNotNull(persona);
	}

	@Test
	void testAgregarClienteJuridico() {
		PersonaJuridica persona = this.movistar.agregarClienteJuridico("Franco", "Nose", 323443,"Empresa");
		assertNull(persona);
		this.movistar.agregarNro(nro1);
		persona = this.movistar.agregarClienteJuridico("Franco", "Nose", 323443,"Empresa");
		assertNotNull(persona);
	}
	
	@Test
	void testFacturar() {
		this.movistar.agregarNro(nro1);
		PersonaJuridica persona = this.movistar.agregarClienteJuridico("Franco", "Nose", 323443,"Empresa");
		Factura factura = this.movistar.facturar(persona, fechaInicio, fechaFin);
		assertNotNull(factura);
	}

}
