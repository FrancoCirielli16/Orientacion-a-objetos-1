package ar.edu.unlp.info.oo1.Ejercicio4;

public class Circulo implements Figura2D {
	private double radio;
	
	public double getDiametro() {
		return this.radio*2;
	}

	public void setDiametro(double diametro) {
		this.radio=diametro/2;
	}

	public double getRadio() {
		return this.radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getArea() {
		return this.radio*radio*Math.PI;
	}
	
	public double getPerimetro() {
		return this.radio*2*Math.PI;
	}
}