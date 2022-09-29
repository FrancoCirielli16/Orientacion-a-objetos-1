package ar.edu.unlp.info.oo1.Ejercicio3;

public class Item {
	private String detalle;
	private int cantidad;
	private int costoUnitario;
	
	
	public Item detalle(String detalle) {
		this.detalle = detalle;
		return this;
	}
	
	public Item costoUnitario(int costoUnitario) {
		this.costoUnitario = costoUnitario;
		return this;
	}
	
	public Item cantidad(int cantidad) {
		this.cantidad = cantidad;
		return this;
	}
	
	public int getCostoUnitario() {
		return costoUnitario;
	}

	public int costo() {
		return this.costoUnitario*this.cantidad;
	}
	
}
