package ar.edu.unlp.info.oo1._Ejercicio18;

import java.time.LocalDate;

public class ContratoDePlanta extends Contrato {
	private double sueldoPorMes;
	private double montoPorTenerConyuge;
	private double montoPorTenerHijos;
	
	public ContratoDePlanta(Empleado empleado, LocalDate fechaDeInicio, double sueldoPorMes, double montoAcordadoPorTenerConyuge,double montoAcordadoPorTenerHijos) {
		super(empleado,fechaDeInicio);
		this.sueldoPorMes = sueldoPorMes;
		this.montoPorTenerConyuge = montoAcordadoPorTenerConyuge;
		this.montoPorTenerHijos = montoAcordadoPorTenerHijos;
	}
	
	public boolean contratoVencido() {
		return false;
	}
	
	public double calcularMonto() {
		if(this.getEmpleado().getTieneConyuge() && (this.getEmpleado().getTieneHijos())) {
			return this.sueldoPorMes+this.montoPorTenerConyuge+this.montoPorTenerHijos;
		}
		if (this.getEmpleado().getTieneConyuge()) {
			return this.sueldoPorMes+this.montoPorTenerConyuge;
		}
		if(this.getEmpleado().getTieneHijos()) {
			return this.sueldoPorMes+this.montoPorTenerHijos;
		}
		
		return this.sueldoPorMes;
	}
}
