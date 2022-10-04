package ar.edu.unlp.info.oo1.Ejercicio13;
import java.util.ArrayList;
import java.util.List;

public class Carpeta {
	private String nombre;
	private List<Email> mails;
	
	public Carpeta(String nombre) {
		this.nombre=nombre;
		mails=new ArrayList<Email>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void agregarMail(Email mail) {
		this.mails.add(mail);
	}
	
	public void eliminarMail(Email mail) {
		this.mails.remove(mail);
	}	
	
	public int tamanioCarpeta() {
		return this.mails.stream().mapToInt(E -> E.tamanioEmail()).sum();
	}
	
	public Email buscar() {
		return this.mails.stream().filter(E -> E.contiene(nombre)).findFirst().orElse(new Email("None","None"));
	}
	
}