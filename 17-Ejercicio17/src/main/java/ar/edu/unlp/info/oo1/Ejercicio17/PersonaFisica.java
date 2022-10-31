package ar.edu.unlp.info.oo1.Ejercicio17;

import java.time.LocalDateTime;

public class PersonaFisica extends Persona {
	private int dni;
	
	
	public PersonaFisica(String nombre, String direccion,int dni, String nroDeTelefono) {
		super(nombre,direccion,nroDeTelefono);
		this.dni = dni;
	}
	
	public double calcularMonto(LocalDateTime fechaInicio,LocalDateTime fechaFin) {
		double monto = super.calcularMonto(fechaInicio,fechaFin);
		return monto - monto * 0.1;
	}
	
}
