package ar.edu.unlp.info.oo1.Parcial1raFecha;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sistema {
	private List<Bien> bienes;
	
	public Sistema() {
		this.bienes= new ArrayList<>();
	}
	
	public Contribuyente darDeAltaContribuyente(String nombre,String dni,String email,String localidad){
		Contribuyente c = new Contribuyente(nombre,dni,email,localidad);
		return c;
	}
	public Inmueble darDeAltaInmueble(int nroPartida,double valorLote,double valorDeEdificacion,Contribuyente propietario){
		Inmueble i = new Inmueble(nroPartida,valorLote,valorDeEdificacion,propietario);
		this.bienes.add(i);
		return i;
	}
	public Automotor darDeAltaAutomotor(String patente, LocalDate fechaDeFabricacion, double valor, Contribuyente propietario,
			String marca, String modelo){
		Automotor a = new Automotor(patente,fechaDeFabricacion,valor,propietario,marca,modelo);
		this.bienes.add(a);
		return a;
	}
	public Embarcacion darDeAltaEmbaracion(String patente, LocalDate fechaDeFabricacion, double valor, Contribuyente propietario,
			String nombre){
		Embarcacion e = new Embarcacion(patente,fechaDeFabricacion,valor,propietario,nombre);
		this.bienes.add(e);
		return e;
	}
	
	public double calcularImpuestoDeContribuyente(Contribuyente propietario) {
		return this.bienes.stream().filter(B -> B.esPropietario(propietario)).mapToDouble(B -> B.calcularMonto()).sum();
	}
	
	public List<Contribuyente> contribuyentesQueMasPagan(String localidad,int n){
		return this.bienes.stream().filter(B -> B.esLocalidad(localidad)).sorted((c1,c2) -> Double.compare(c1.calcularMonto(),c2.calcularMonto())).map(C -> C.getContribuyente()).limit(n).collect(Collectors.toList());
	}
}
