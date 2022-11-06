package ar.edu.unlp.info.oo1.Parcial1raFecha;

import java.time.LocalDate;

public class Embarcacion extends BienMotor {
	private String nombre;
	
	public Embarcacion(String patente, LocalDate fechaDeFabricacion, double valor, Contribuyente propietario,String nombre) {
		super(patente, fechaDeFabricacion, valor, propietario);
		this.nombre=nombre;
	}
	
	@Override
	public double calcularMonto() {
		if(this.supera10Años()) {
			return 0;
		}
		if (!this.superaMillon()) {
			return this.calcularMonto(0.10);
		}
		return this.calcularMonto(0.15);
	}

}
