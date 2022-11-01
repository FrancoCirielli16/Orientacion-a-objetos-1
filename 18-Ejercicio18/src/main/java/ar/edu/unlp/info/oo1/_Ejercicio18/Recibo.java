package ar.edu.unlp.info.oo1._Ejercicio18;

import java.time.LocalDate;

public class Recibo {
	private Empleado empleado;
	private int antiguedad;
	private LocalDate fechaDeRecibo;
	private double montoACobrar;
	
	public Recibo(Empleado empleado, int antiguedad,double montoACobrar) {
		this.empleado=empleado;
		this.antiguedad = antiguedad;
		this.fechaDeRecibo = LocalDate.now();
		this.montoACobrar = montoACobrar;
	}
	
	
}
