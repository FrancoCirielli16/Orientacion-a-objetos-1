package ar.edu.unlp.info.oo1._Ejercicio17;

public class PersonaFisica extends Persona {
	private int dni;
	
	
	public PersonaFisica(String nombre, String direccion,int dni, String nroDeTelefono) {
		super(nombre,direccion,nroDeTelefono);
		this.dni = dni;
	}
	
	
}
