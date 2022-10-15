package ar.edu.unlp.info.oo1._Ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;

	public ClienteDeCorreo(String carpeta) {
		this.inbox=new Carpeta(carpeta);
		this.carpetas=new ArrayList<Carpeta>();
		this.carpetas.add(inbox);
	}

	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}

	public Email buscar (String txt) {
		Email email=this.carpetas.stream().map(C -> C.buscar(txt)).findFirst().orElse(null);
		if (email.getCuerpo().equals("None")) {
			return null;
		}
		return email;
	}

	public void recibir(Email email) {
		this.inbox.agregarMail(email);
	}

	public void mover(Carpeta origen, Carpeta destino, Email email) {
		destino.agregarMail(email);
		origen.eliminarMail(email);
	}

	public int espacioOcupado() {
		return this.carpetas.stream().mapToInt(C -> C.tamanioCarpeta()).sum();
	}

	public Carpeta getInbox() {
		return this.inbox;
	}

	public List<Carpeta> getCarpetas() {
		return new ArrayList<Carpeta>(carpetas);
	}
	
	
	
	
}
