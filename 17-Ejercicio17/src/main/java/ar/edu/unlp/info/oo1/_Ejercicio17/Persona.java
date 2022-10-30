package ar.edu.unlp.info.oo1._Ejercicio17;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
	private String nombre;
	private String direccion;
	private String nroDeTelefono;
	private List<Factura> facturas;
	private List<Llamada> llamadas;
	
	public Persona(String nombre, String direccion, String nroDeTelefono) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.nroDeTelefono=nroDeTelefono;
		this.llamadas=new ArrayList<Llamada>();
		this.facturas=new ArrayList<Factura>();
	}
	
	public void agregarNro(String nroDeTelefono) {
		this.nroDeTelefono=nroDeTelefono;
	}
	
	public Factura facturar() {}
	
	public LlamadaLocal registrarLlamadaLocal() {}
	
	public LlamadaInternacional registrarLlamadaInternacional() {}
	
	public LlamadaInterUrbana registrarLlamadaInterUrbana() {}
}
