package ar.edu.unlp.oo1.Ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private String direccion;
	private double precioPorNoche;
	private List<Reserva> reservas;

	public Propiedad(String nombre, String direccion, String descripcion, double precioPorNoche) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.precioPorNoche=precioPorNoche;
		this.descripcion=descripcion;
		this.reservas=new ArrayList<Reserva>();
	}
	
	public void hacerReserva(DateLapse periodo , Usuario usuario) {
		if (this.reservas.stream().anyMatch(P -> P.validarPeriodo(periodo.getFrom(), periodo.getTo()) == true) == false) {
			Reserva r = new Reserva(usuario,periodo,this);
			this.reservas.add(r);
		}
	}
	
	public double calcularIngreso(LocalDate fecha1, LocalDate fecha2) {
		return this.reservas.stream().filter(R -> R.validarPeriodo(fecha1, fecha2) == true).mapToDouble(R -> R.calcularPrecio()).sum();
	}
	
	public boolean eliminarReserva() {
		
	}
	
	
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}

}
