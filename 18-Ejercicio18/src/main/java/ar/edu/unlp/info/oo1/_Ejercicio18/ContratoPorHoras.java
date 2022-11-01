package ar.edu.unlp.info.oo1._Ejercicio18;

import java.time.LocalDate;

public class ContratoPorHoras extends Contrato {
	private double valorPorHoras;
	private int horasDeTrabajoPorMes;
	private LocalDate fechaDeVencimiento;
	
	
	public ContratoPorHoras(Empleado empleado,LocalDate fechaDeInicio, LocalDate fechaDeVencimiento,double valorPorHoras, int horasDeTrabajoPorMes) {
		super(empleado,fechaDeInicio);
		this.valorPorHoras = valorPorHoras;
		this.horasDeTrabajoPorMes = horasDeTrabajoPorMes;
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public boolean contratoVencido() {
		return (this.fechaDeVencimiento.isBefore(LocalDate.now())||this.fechaDeVencimiento.isEqual(LocalDate.now()));
		
	}
	
	public double calcularMonto() {
		return this.valorPorHoras*this.horasDeTrabajoPorMes;
	}
}
