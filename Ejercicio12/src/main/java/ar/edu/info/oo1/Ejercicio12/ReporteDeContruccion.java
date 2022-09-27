package ar.edu.info.oo1.Ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeContruccion {
	private List<Pieza> Piezas;
	
	public ReporteDeContruccion() {
		this.Piezas = new ArrayList<Pieza>();
	}
	
	public void agregarPieza(Pieza P){
		this.Piezas.add(P);
	}

	public double getVolumenDeMaterial(String nombreDeMaterial) {
		return this.Piezas.stream().filter(Pieza -> Pieza.getMaterial() == nombreDeMaterial).mapToDouble(P -> P.volumen()).sum();
	}
	
	
	public double getSuperficieDeColor(String unNombreDeColor) {
		return this.Piezas.stream().filter(Pieza -> Pieza.getColor() != unNombreDeColor).mapToDouble(P -> P.superficie()).sum();
	}
}
