package ar.edu.unlp.info.oo1.Ejercicio15;

import java.time.LocalDate;

public class Reserva {
	private DateLapse periodo;
	private Usuario inquilino;
	private Propiedad propiedad;
	

	public Reserva (DateLapse periodo,Usuario inquilino, Propiedad propiedad) {
		this.inquilino=inquilino;
		this.periodo=periodo;
		this.propiedad=propiedad;
	}
	
	public double calcularPrecio(DateLapse periodo) {
		DateLapse ini = periodo.getFrom().isBefore(this.periodo.getFrom()) ? this.periodo:periodo;
		DateLapse fin = periodo.getTo().isAfter(this.periodo.getTo()) ? this.periodo:periodo;
		if (fin.getTo().isBefore(ini.getFrom())) {
			return 0;
		}
		//return this.propiedad.getPrecioPorNoche() * this.periodo.sizeInDays();
		return this.propiedad.getPrecioPorNoche() * new DateLapse(ini.getFrom(),fin.getTo()).sizeInDays();	
	}
	
	public boolean validarFecha() {
		return this.periodo.getTo().isAfter(LocalDate.now());
	}
	
	public boolean seSuperpone(DateLapse periodo) {
		return this.periodo.OverLapse(periodo);
	}
	
	public boolean esUsuario(Usuario nombre) {
		return this.inquilino.equals(nombre);
	}
}
