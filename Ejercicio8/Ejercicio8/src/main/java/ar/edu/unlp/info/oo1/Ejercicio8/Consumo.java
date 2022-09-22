package ar.edu.unlp.info.oo1.Ejercicio8;

import java.time.LocalDate;

public class Consumo {

	private LocalDate fecha;
	private double consumoDeEnergiaActiva;
	private double consumoDeEnergiaReactiva;

	public Consumo(LocalDate fecha, double consumoActiva, double consumoReactiva) {
		this.fecha = fecha;
		this.consumoDeEnergiaActiva = consumoActiva;
		this.consumoDeEnergiaReactiva = consumoReactiva;
	}
	
	public double costoEnBaseA(double precioKWh) {
		return this.consumoDeEnergiaActiva * precioKWh;
	}
		
	public double factorDePotencia(){
		return this.consumoDeEnergiaActiva/ Math.sqrt(Math.pow(consumoDeEnergiaReactiva, 2) + Math.pow(this.consumoDeEnergiaReactiva,2));
	}

	
	
	public double getConsumoDeEnergiaActiva() {
		return consumoDeEnergiaActiva;
	}

	public double getConsumoDeEnergiaReactiva() {
		return consumoDeEnergiaReactiva;
	}

	public LocalDate getFecha() {
		return this.fecha;
	}
}
