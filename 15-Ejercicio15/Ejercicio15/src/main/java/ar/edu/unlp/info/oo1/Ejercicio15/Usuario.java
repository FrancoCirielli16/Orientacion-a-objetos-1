package ar.edu.unlp.info.oo1.Ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario {
	private String nombre;
	private int dni;
	private String direccion;
	private List<Propiedad> propiedades;
	
	public Usuario(String nombre, String direccion, int dni) {
		this.nombre=nombre;
		this.direccion=direccion;
		this.dni=dni;
		this.propiedades= new ArrayList<Propiedad>();	

	}
	
	public Propiedad registrarPropiedad(String nombre, String descripcion, String direccion, double precio) {
		Propiedad P = new Propiedad(nombre,descripcion,direccion,precio);
		this.propiedades.add(P);
		return P;
	}
	
	public double calcularIngreso(DateLapse periodo) {
		return this.propiedades.stream().mapToDouble(P -> P.calcularIngreso(periodo)).sum();
	}
	
	public List<Reserva> ObtenerReserva(Usuario usuario){
		return this.propiedades.stream()
				.flatMap(R -> R.devolverReservas(usuario).stream())
				.collect(Collectors.toList());
	}

	public String getNombre() {
		return this.nombre;
	}
}
