package ar.edu.unlp.info.oo1.Ejercicio4;

public class Cuadrado implements Figura2D {
	private double lado;
	
	public double getLado() {
		return this.lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getArea() {
		return this.lado*this.lado;
	}
	
	public double getPerimetro() {
		return this.lado*4;
	}
}
