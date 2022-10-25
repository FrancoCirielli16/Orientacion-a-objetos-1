package ar.edu.unlp.oo1.Ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Usuario inquilino;
	private Propiedad propiedad;
	
	public Reserva (Usuario inquilino,DateLapse periodo, Propiedad propiedad) {
		this.inquilino=inquilino;
		this.periodo=periodo;
		this.propiedad=propiedad;
	}
	
	public double calcularPrecio() {
		return this.propiedad.getPrecioPorNoche() * this.periodo.sizeInDays();
	}
	
	public boolean validarPeriodo(LocalDate fecha1, LocalDate fecha2) {
		return this.periodo.includesDate(fecha1) && this.periodo.includesDate(fecha2);
	}
	

}
