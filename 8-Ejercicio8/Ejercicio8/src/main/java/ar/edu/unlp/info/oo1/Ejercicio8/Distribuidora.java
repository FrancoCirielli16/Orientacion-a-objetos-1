	package ar.edu.unlp.info.oo1.Ejercicio8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Distribuidora {
	
	private double precioKWh;
	private List<Usuario> usuarios;

	public Distribuidora(double preciokw) {
		this.precioKWh(preciokw);
		this.usuarios = new ArrayList();
	}
	
	public void agregarUsuario(Usuario usuario) {
		if (!this.usuarios.contains(usuario)) {
			this.usuarios.add(usuario);
		}
	}
	
	public List<Factura> facturar() {
		return this.usuarios.stream().map((usuario) -> usuario.facturarEnBaseA(precioKWh)).toList();
	}
	
	
	public double consumoTotalActiva() {
		return this.usuarios.stream().mapToDouble((usuario) -> usuario.ultimoConsumoActiva()).sum();
	}

	public void precioKWh(double precio) {
		this.precioKWh = precio;
	}
	
	public double getPrecioKW() {
		return this.precioKWh;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
}
