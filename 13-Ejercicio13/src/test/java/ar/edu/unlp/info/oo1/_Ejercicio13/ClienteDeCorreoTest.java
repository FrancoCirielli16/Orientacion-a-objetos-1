package ar.edu.unlp.info.oo1._Ejercicio13;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteDeCorreoTest {
	private	ClienteDeCorreo cliente;
	private Carpeta origen,destino;
	private Email e1,e2,e3;
	private Archivo a1,a2,a3,a4;
	
	
	@BeforeEach
	public void SetUp() {
		this.cliente=new ClienteDeCorreo("Inbox");
		this.origen=new Carpeta("Facultad");
		this.destino=new Carpeta("Recomendado");
		this.e1=new Email("Nota", "Su nota es: 6");
		this.e2=new Email("Compras","Lista de compras");
		this.e3=new Email("Certificados","Aca tienen los certificados");
		this.a1=new Archivo("Compras");
		this.a2=new Archivo("Certificado1");
		this.a3=new Archivo("Certificado2");
		this.a4=new Archivo("Nota y firmas");
		this.cliente.agregarCarpeta(destino);
		this.cliente.agregarCarpeta(origen);
		
	}
	

	@Test
	public void constructorClienteTest() {
		assertTrue(!cliente.getCarpetas().isEmpty());		
	}
	
	@Test
	public void agregarCarpetaTest() {
		assertTrue(cliente.getCarpetas().contains(origen));
		assertTrue(cliente.getCarpetas().contains(destino));
	}
	
	@Test
	public void agregarMailImboxTest() {
		cliente.recibir(e1);
		assertTrue(cliente.getInbox().obtenerMails().contains(e1));
		assertFalse(cliente.getInbox().obtenerMails().contains(e2));		
	}
	
	@Test
	public void buscarTest() {
		assertEquals(null,this.cliente.buscar("Spam"));
		this.cliente.recibir(e1);
		this.cliente.mover(this.cliente.getInbox(), destino, e1);
		assertEquals(this.e1,this.cliente.buscar("Nota"));	
	}
	
	@Test
	public void moverMailTest() {
		this.cliente.mover(origen, destino, e1);
		assertTrue(this.destino.obtenerMails().contains(e1));
		assertFalse(this.origen.obtenerMails().contains(e1));
	}
	
	@Test
	public void espacioOcupadoTest() {
		this.e1.agregarAdjunto(a4);
		this.e2.agregarAdjunto(a1);
		this.e3.agregarAdjunto(a2);
		this.e3.agregarAdjunto(a3);
		this.cliente.recibir(e1);
		this.cliente.recibir(e2);
		this.cliente.recibir(e3);
		this.cliente.mover(this.cliente.getInbox(), destino, e1);
		this.cliente.mover(this.cliente.getInbox(), destino, e2);
		this.cliente.mover(this.cliente.getInbox(), destino, e3);
		assertEquals(123,this.cliente.espacioOcupado());
	}
	
	
}
