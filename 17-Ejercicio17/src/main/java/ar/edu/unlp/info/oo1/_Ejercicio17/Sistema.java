package ar.edu.unlp.info.oo1._Ejercicio17;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<String> listaDeNros;
	private List<Persona> clientes;
	
	public Sistema() {
		this.clientes=new ArrayList<Persona>();
		this.listaDeNros= new ArrayList<String>();
	}
	
	public Factura facturar() {}
	
	public void agregarNro(String numero) {}
	
	public PersonaFisica agregarClienteFisico(String nombre,String direccion,int dni) {
		if(!this.listaDeNros.isEmpty()) {
			PersonaFisica P = new PersonaFisica(nombre,direccion,dni,this.listaDeNros.remove(0));
			this.clientes.add(P);
			return P;
		}
		return null;
	}
	
	public PersonaJuridica agregarClienteJuridico(String nombre,String direccion,int cuit, String tipo) {}
}