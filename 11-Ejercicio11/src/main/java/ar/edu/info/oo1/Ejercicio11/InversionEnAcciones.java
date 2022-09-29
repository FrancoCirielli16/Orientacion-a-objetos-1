package ar.edu.info.oo1.Ejercicio11;

public class InversionEnAcciones implements inversion {
	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	
	public InversionEnAcciones(String nombre, int cantidad, double valorUnitario) {
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.valorUnitario = valorUnitario;
	}

	public double valorActual() {
		return this.valorUnitario*this.cantidad;
	}
	
	
}
