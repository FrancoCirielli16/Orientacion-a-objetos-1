package ar.edu.unlp.info.oo1.Ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Email {
	private String titulo, cuerpo;
	private List<Archivo> adjuntos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo=titulo;
		this.cuerpo=cuerpo;
		this.adjuntos= new ArrayList<Archivo>();
	}
	
	public void agregarAdjunto(Archivo archivo) {
		this.adjuntos.add(archivo);
	}
		
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos(){
		return new ArrayList<Archivo>(adjuntos);
	}
	
	public int tamanioEmail() {
		return this.titulo.length()+this.cuerpo.length()+ this.tamanioAdjuntos();
	}
	
	private int tamanioAdjuntos() {
		int total= this.adjuntos.stream().mapToInt(Archivo::tamanio ).sum();
		return total;
	}
	
	public boolean contiene(String texto) {
		return (this.titulo.equals(texto)) || (this.cuerpo.equals(texto));
	}
	
	
	
	
}