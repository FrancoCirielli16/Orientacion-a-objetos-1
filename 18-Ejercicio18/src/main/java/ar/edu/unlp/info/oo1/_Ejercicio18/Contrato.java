package ar.edu.unlp.info.oo1._Ejercicio18;

import java.time.LocalDate;

public abstract class Contrato {
	private Empleado empleado;
	private LocalDate fechaDeInicio;

	public Contrato(Empleado empleado,LocalDate fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
		this.empleado=empleado;
	}
	
	public abstract boolean contratoVencido();
	
	public abstract double calcularMonto();
	
	public LocalDate getFechaInicio() {
		return this.fechaDeInicio;
	}	
	
	public Empleado getEmpleado() {
		return this.empleado;
	}
	
}
