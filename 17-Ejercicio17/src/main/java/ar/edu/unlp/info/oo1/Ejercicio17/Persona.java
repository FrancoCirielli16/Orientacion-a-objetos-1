package ar.edu.unlp.info.oo1.Ejercicio17;

import java.time.LocalDateTime;
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
	
	public Factura facturar(LocalDateTime fechaInicio,LocalDateTime fechaFin) {
		Factura factura = new Factura (this,fechaInicio,fechaFin,LocalDateTime.now(),this.calcularMonto(fechaInicio,fechaFin));
		return factura;
	}
	
	public double calcularMonto(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return this.llamadas.stream().filter(l -> l.inLapse(fechaInicio,fechaFin)).mapToDouble(l -> l.calcularCosto()).sum();
	}
	
	public LlamadaLocal registrarLlamadaLocal(LocalDateTime fecha, int duracion,String nroEmisor,String nroReceptor) {
		LlamadaLocal llamada = new LlamadaLocal (fecha,duracion,nroEmisor,nroReceptor);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime fecha, int duracion,String nroEmisor,String nroReceptor,String paisOrigen,String paisDestino) {
		LlamadaInternacional llamada = new LlamadaInternacional (fecha,duracion,nroEmisor,nroReceptor,paisOrigen,paisDestino);
		this.llamadas.add(llamada);
		return llamada;
	}
	
	public LlamadaInterUrbana registrarLlamadaInterUrbana(LocalDateTime fecha, int duracion,String nroEmisor,String nroReceptor,int distanciaEnKilometro) {
		LlamadaInterUrbana llamada = new LlamadaInterUrbana (fecha,duracion,nroEmisor,nroReceptor,distanciaEnKilometro);
		this.llamadas.add(llamada);
		return llamada;
	}
}
