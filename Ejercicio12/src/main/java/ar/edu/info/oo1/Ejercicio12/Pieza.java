package ar.edu.info.oo1.Ejercicio12;

public abstract class Pieza {
	private String material;
	private String color;
	
	
	public Pieza(String material, String color) {
		this.material = material;
		this.color = color;
	}


	public String getMaterial() {
		return this.material;
	}
	
	public String getColor() {
		return this.color;
	}
	
	
	public abstract double volumen();

	public abstract double superficie();
	
}
