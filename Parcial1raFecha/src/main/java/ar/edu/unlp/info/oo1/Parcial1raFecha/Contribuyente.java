package ar.edu.unlp.info.oo1.Parcial1raFecha;

public class Contribuyente {
	private String nombre;
	private String dni;
	private String email;
	private String localidad;
	
	public Contribuyente(String nombre,String dni,String email,String localidad) {
		this.nombre=nombre;
		this.dni=dni;
		this.email=email;
		this.localidad=localidad;
	}
	
	public boolean esLocalidad(String localidad) {
		return this.localidad == localidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
