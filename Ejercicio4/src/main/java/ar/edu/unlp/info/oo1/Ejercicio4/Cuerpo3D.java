package ar.edu.unlp.info.oo1.Ejercicio4;

public class Cuerpo3D {
	private Figura2D caraBasal;
	private double altura;
	
	public void setCaraBasal(Figura2D caraBasal) {
		this.caraBasal=caraBasal;
	}
	
	public void setAltura(double altura) {
		this.altura=altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public double getVolumen() {
		return this.caraBasal.getArea()*this.altura;
	}
	
	public double getSuperficieExterior() {
		return (2*this.caraBasal.getArea()) + this.caraBasal.getPerimetro()*this.altura;
	}
}
