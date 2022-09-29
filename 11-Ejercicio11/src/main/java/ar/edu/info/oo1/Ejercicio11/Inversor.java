package ar.edu.info.oo1.Ejercicio11;

import java.util.ArrayList;
import java.util.List;

public class Inversor {
	private String nombre;
	private List<inversion> inversiones;
	
	public Inversor(String nombre) {
		this.nombre = nombre;
		this.inversiones = new ArrayList<inversion>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void cargarInversion(inversion I) {
		this.inversiones.add(I);
	}	
	
	public double valorActual() {
		return this.inversiones.stream().mapToDouble(inverion -> inverion.valorActual()).sum();
	}
	
}
