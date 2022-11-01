package ar.edu.unlp.info.oo1._Ejercicio18;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {
	private double sueldoPorMes;
	private double montoPorTenerConyuge;
	private double montoPorTenerHijos;
	
	public ContratoDePlanta(Empleado empleado, LocalDate fechaDeInicio, double sueldoPorMes, double montoAcordadoPorTenerConyuge,double montoAcordadoPorTenerHijos) {
		super(empleado,fechaDeInicio);
		this.sueldoPorMes = sueldoPorMes;
		this.montoPorTenerConyuge = montoPorTenerConyuge;
		this.montoPorTenerHijos = montoPorTenerHijos;
	}
	
	public boolean contratoVencido() {
		return false;
	}
	
	public double calcularMonto() {
		if (this.tieneConyuge()) {
			return this.sueldoPorMes+this.montoPorTenerConyuge;
		}else
			if(this.tieneHijos()) {
				return this.sueldoPorMes+this.montoPorTenerHijos;
			}
		return this.sueldoPorMes;
	}
}
