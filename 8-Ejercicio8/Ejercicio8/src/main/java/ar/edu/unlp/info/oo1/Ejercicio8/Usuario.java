package ar.edu.unlp.info.oo1.Ejercicio8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private String domicilio;
	private List<Factura> facturas;
	private List<Consumo> consumos;

	public Usuario(String nombre, String domicilio) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.facturas = new ArrayList<Factura>();
		this.consumos = new ArrayList<Consumo>();
	}
	
	public void agregarMedicion(Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	public Consumo ultimoConsumo(){
		return this.consumos.stream().max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha())).orElse(null);
	}
	
	public double ultimoConsumoActiva() {
		if (this.ultimoConsumo()!=null) {
			return this.ultimoConsumo().getConsumoDeEnergiaActiva();
		}
		return 0d;
	}
	
	public Factura facturarEnBaseA(double precioKWh) {
		Consumo ultimo = this.ultimoConsumo();
		if (ultimo != null) {
			if (ultimo.factorDePotencia()>0.8d) {
				return new Factura (ultimo.costoEnBaseA(precioKWh),10,this);
			}
			return new Factura (ultimo.costoEnBaseA(precioKWh),0,this);
		}
		return new Factura(0,0,this);
	}

	
	public List<Consumo> getConsumos(){
		return this.consumos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}	
}
