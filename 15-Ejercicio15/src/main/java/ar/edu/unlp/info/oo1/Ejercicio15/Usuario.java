package ar.edu.unlp.info.oo1.Ejercicio15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
