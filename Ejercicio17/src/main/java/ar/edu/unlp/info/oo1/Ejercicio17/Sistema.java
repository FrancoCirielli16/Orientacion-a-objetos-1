package ar.edu.unlp.info.oo1.Ejercicio17;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<String> listaDeNros;
	private List<Persona> clientes;
	
	public Sistema() {
		this.clientes=new ArrayList<Persona>();
		this.listaDeNros= new ArrayList<String>();
	}
	
	public Factura facturar(Persona cliente,LocalDateTime fechaInicio,LocalDateTime fechaFin) {
		return cliente.facturar(fechaInicio,fechaFin);
	}
	
	public void agregarNro(String numero) {
		this.listaDeNros.add(numero);
	}
	
	public PersonaFisica agregarClienteFisico(String nombre,String direccion,int dni) {
		//Si la lista de numeros esta vacia
		if(this.listaDeNros.isEmpty()) {
			return null;
		}
		PersonaFisica persona = new PersonaFisica(nombre,direccion,dni,this.listaDeNros.remove(0));
		this.clientes.add(persona);
		return persona;
	}
	
	public PersonaJuridica agregarClienteJuridico(String nombre,String direccion,int cuit, String tipo) {
		//Si la lista de numeros esta vacia
		if(this.listaDeNros.isEmpty()) {
			return null;
		}
		PersonaJuridica persona = new PersonaJuridica(nombre,direccion,cuit,tipo,this.listaDeNros.remove(0));
		this.clientes.add(persona);
		return persona;
	}
	
	public int getListaDeNrosSize() {
		return this.listaDeNros.size();
	}
}