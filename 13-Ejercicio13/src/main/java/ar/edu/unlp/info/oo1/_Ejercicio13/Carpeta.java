package ar.edu.unlp.info.oo1._Ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> emails;

	public Carpeta(String nombre) {
		this.nombre=nombre;
		emails=new ArrayList<Email>();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void agregarMail(Email mail) {
		this.emails.add(mail);
	}

	public void eliminarMail(Email mail) {
		this.emails.remove(mail);
	}	

	public int tamanioCarpeta() {
		return this.emails.stream().mapToInt(E -> E.tamanioEmail()).sum();
	}

	public Email buscar(String txt) {
		return this.emails.stream().filter(E -> E.contiene(txt)).findFirst().orElse(new Email("None","None"));
	}

	public List<Email> obtenerMails(){
		return new ArrayList<Email>(emails);
	}

}
