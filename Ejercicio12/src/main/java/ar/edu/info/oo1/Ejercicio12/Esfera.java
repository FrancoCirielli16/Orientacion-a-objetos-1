package ar.edu.info.oo1.Ejercicio12;

public class Esfera extends Pieza{
	private int radio;

	public Esfera(String material, String color, int radio) {
		super(material, color);
		this.radio = radio;
	}

	public int getRadio() {
		return radio;
	}
	

	public double volumen() {
		return 4/3*Math.PI*Math.pow(this.radio,3);
	}
	
	public double superficie() {
		return 4*Math.PI*Math.pow(this.radio,2);
	}
}
