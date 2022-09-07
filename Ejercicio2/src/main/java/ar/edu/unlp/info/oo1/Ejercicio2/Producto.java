package ar.edu.unlp.info.oo1.Ejercicio2;

public class Producto {
	private double peso;
	private String descripcion;
	private double precioPorKilo;
	
	
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setPrecioPorKilo(double precioPorKilo) {
		this.precioPorKilo = precioPorKilo;
	}
	
	
	
	public double getPeso() {
		return this.peso;
	}
	
	public double getPrecioPorKilo() {
		return this.precioPorKilo;
	}
	
	public double getPrecio() {
		return this.peso * this.precioPorKilo;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
}
