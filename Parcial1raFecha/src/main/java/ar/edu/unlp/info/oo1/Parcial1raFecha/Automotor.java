package ar.edu.unlp.info.oo1.Parcial1raFecha;

import java.time.LocalDate;

public class Automotor extends BienMotor{
	private String marca;
	private String modelo;
	
	
	




	public Automotor(String patente, LocalDate fechaDeFabricacion, double valor, Contribuyente propietario,
			String marca, String modelo) {
		super(patente, fechaDeFabricacion, valor, propietario);
		this.marca = marca;
		this.modelo = modelo;
	}




	public double calcularMonto() {
		if(this.supera10Años()) {
			return 0;
		}
		return this.calcularMonto(0.5);
	}

}
