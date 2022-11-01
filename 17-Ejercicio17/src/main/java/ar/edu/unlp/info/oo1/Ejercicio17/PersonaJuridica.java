package ar.edu.unlp.info.oo1.Ejercicio17;

public class PersonaJuridica extends Persona{
	private int cuit;
	private  String tipo;
	
	public PersonaJuridica(String nombre, String direccion,int cuit, String tipo,String nroDeTelefono) {
		super(nombre,direccion,nroDeTelefono);
		this.cuit = cuit;
		this.tipo = tipo;
	}
	
	

	
}
