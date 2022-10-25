package ar.edu.unlp.oo1.Ejercicio15;

import java.time.LocalDate;
import java.util.List;

public class OOBNB {
	private List<Usuario> usuarios;
	
	
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario U = new Usuario(nombre,direccion,dni);
		this.usuarios.add(U);
		return U;
	}
	
	public List<Propiedad> buscarPropiedad() {
		return null;
	}
	
	public List<Reserva> obtenerReserva() {
		return null;
	}
	
	public double calcularIngresoDePropietario(Usuario usuario, LocalDate fecha1, LocalDate fecha2) {
		return usuario.calcularIngreso(fecha1, fecha2);
	}
	
}
