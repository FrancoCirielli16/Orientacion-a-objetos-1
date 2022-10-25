package ar.edu.unlp.info.oo1.Ejercicio15;

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
	
	public boolean validarFecha(LocalDate f) {
		return this.periodo.getTo().isAfter(f);
	}
	public boolean validarPeriodo(DateLapse periodo) {
		return this.periodo.OverLapse(periodo);
	}

}
