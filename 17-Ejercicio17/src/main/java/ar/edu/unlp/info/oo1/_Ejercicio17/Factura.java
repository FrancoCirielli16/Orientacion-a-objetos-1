package ar.edu.unlp.info.oo1._Ejercicio17;

import java.time.LocalDate;

public class Factura {
	private Persona cliente;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate fechaFacturacion;
	private Double monto;

	public Factura(Persona cliente, LocalDate fechaInicio, LocalDate fechaFin, LocalDate fechaFacturacion, double monto) {
		this.cliente=cliente;
		this.fechaInicio=fechaInicio;
		this.fechaFacturacion=fechaFacturacion;
		this.fechaFin=fechaFin;
		this.monto=monto;
	}
	
}
