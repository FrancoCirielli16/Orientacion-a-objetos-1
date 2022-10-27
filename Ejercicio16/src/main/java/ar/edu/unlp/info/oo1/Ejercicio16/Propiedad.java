package ar.edu.unlp.info.oo1.Ejercicio16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private String direccion;
	private Politica tipoDePolitica;
	private double precioPorNoche;
	private List<Reserva> reservas;

	public Propiedad(String nombre, String direccion, String descripcion, Politica tipoDePolitica,double precioPorNoche) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.precioPorNoche=precioPorNoche;
		this.descripcion=descripcion;
		this.tipoDePolitica=tipoDePolitica;
		this.reservas=new ArrayList<Reserva>();
	}
	
	private void agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}
	
	public Reserva hacerReserva(DateLapse periodo , Usuario usuario) {
		if (this.reservas.stream().anyMatch(P -> P.seSuperpone(periodo)) == false){
			Reserva r = new Reserva(periodo,usuario,this);
			this.agregarReserva(r);
			return r;
		}
		else 
			return null;
			
	}
	
	public double calcularIngreso(DateLapse periodo) {
		return this.reservas.stream().filter(R -> R.seSuperpone(periodo) == true).mapToDouble(R -> R.calcularPrecio(periodo)).sum();
	}
	
	public boolean eliminarReserva(Reserva r) {
		if (r.validarFecha()){
			if(this.reservas.contains(r)) {
				reservas.remove(r);
				return true;
			}
			return false;
		}
		else 
			return false;
	}
	
	public boolean validarPropiedad(DateLapse periodo) {
		return this.reservas
				.stream()
				.anyMatch(R -> R.seSuperpone(periodo));
	}
	
	public List<Reserva> devolverReservas(Usuario usuario){
		return this.reservas
				.stream()
				.filter(R -> R.esUsuario(usuario))
				.collect(Collectors.toList());
	}
	
	public double getPrecioPorNoche() {
		return this.precioPorNoche;
	}
	
	public Politica getTipoCancelacion() {
		return this.tipoDePolitica;
	}

	
	

}
