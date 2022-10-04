package ar.edu.unlp.info.oo1.Ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo(Carpeta carpeta) {
		this.inbox=carpeta;
		this.carpetas=new ArrayList<Carpeta>();
		this.carpetas.add(inbox);
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
	
	public Email buscar (String txt) {
		Email email=this.carpetas.stream().map(C -> C.buscar()).findFirst().orElse(null);
		if (email.getCuerpo().equals("None")) {
			return null;
		}
		return email;
	}
	
	public void recibir(Email email) {}
	
	public void mover(String origen, String destino, Email email) {}
	
	public int espacioOcupado() {}
}
