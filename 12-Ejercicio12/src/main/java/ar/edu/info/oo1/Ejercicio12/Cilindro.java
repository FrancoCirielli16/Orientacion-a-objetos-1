package ar.edu.info.oo1.Ejercicio12;

public class Cilindro extends Pieza {
	private int radio;
	private int altura;
	
	
	
	

	
	public Cilindro(String material, String color, int radio, int altura) {
		super(material, color);
		this.radio = radio;
		this.altura = altura;
	}

	public int getRadio() {
		return this.radio;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	
	public double volumen() {
		return Math.PI*Math.pow(this.radio,2)*this.altura;
	}
	
	public double superficie() {
		return 2*Math.PI*this.radio*this.altura+2*Math.PI*Math.pow(this.radio,2);
	}
	
}
