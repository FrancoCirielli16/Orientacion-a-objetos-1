package ar.edu.unlp.info.oo1.Ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
	
	private void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public Reserva hacerReserva(DateLapse periodo , Usuario usuario) {
		if (this.reservas.stream().anyMatch(P -> P.validarPeriodo(periodo))){
			Reserva r = new Reserva(usuario,periodo,this);
			this.agregarReserva(r);
			return r;
		}
		else 
			return null;
			
	}
	
	public double calcularIngreso(DateLapse periodo) {
		return this.reservas.stream().filter(R -> R.validarPeriodo(periodo) == true).mapToDouble(R -> R.calcularPrecio()).sum();
	}
	
	public boolean eliminarReserva(Reserva r) {
		LocalDate f = LocalDate.now();
		if (r.validarFecha(f)){
			reservas.remove(r);
			return true;
		}
		else 
			return false;
	}
	
	public List<Reserva> devolverReservas(Usuario usuario){
		return this.reservas.stream().filter(R -> R.esUsuario(usuario)).collect(Collectors.toList());
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	

}
