package ar.edu.unlp.info.oo1._Ejercicio17;

import java.time.LocalDateTime;

public abstract class Llamada {
	private LocalDateTime fecha;
	private double duracion;
	private String telefonoOrigen;
	private String telefonoReceptor;
		
	
	
	public Llamada(LocalDateTime fecha, double duracion, String telefonoOrigen, String telefonoReceptor) {
		super();
		this.fecha = fecha;
		this.duracion = duracion;
		this.telefonoOrigen = telefonoOrigen;
		this.telefonoReceptor = telefonoReceptor;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getTelefonoOrigen() {
		return telefonoOrigen;
	}

	public String getTelefonoReceptor() {
		return telefonoReceptor;
	}

	protected double calcularCosto(double monto) {
		return this.duracion*monto;
	}
	
}

