package ar.edu.info.oo1.Ejercicio12;

public class PrismaRectangular extends Pieza{
	private int ladoMayor;
	private int ladoMenor;
	private int altura;
	
	
	public PrismaRectangular(String material, String color, int ladoMayor, int ladoMenor, int altura) {
		super(material, color);
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
		this.altura = altura;
	}


	public int getLadoMayor() {
		return ladoMayor;
	}


	public int getLadoMenor() {
		return ladoMenor;
	}


	public int getAltura() {
		return altura;
	}
	
	
	public double volumen() {
		return this.ladoMayor*this.ladoMenor*this.altura;
	}
	
	public double superficie() {
		return 2*(this.ladoMayor*this.ladoMenor+this.ladoMayor*this.altura+this.ladoMenor*this.altura);
	}
	
	
}


