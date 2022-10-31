package ar.edu.unlp.info.oo1.Ejercicio17;

import java.time.LocalDateTime;

public class Factura {
	private Persona cliente;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private LocalDateTime fechaFacturacion;
	private Double monto;

	public Factura(Persona cliente, LocalDateTime fechaInicio, LocalDateTime fechaFin, LocalDateTime fechaFacturacion, double monto) {
		this.cliente=cliente;
		this.fechaInicio=fechaInicio;
		this.fechaFacturacion=fechaFacturacion;
		this.fechaFin=fechaFin;
		this.monto=monto;
	}
	
}
