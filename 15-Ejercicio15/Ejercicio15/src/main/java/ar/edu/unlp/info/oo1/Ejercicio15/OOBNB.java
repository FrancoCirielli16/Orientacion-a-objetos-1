package ar.edu.unlp.info.oo1.Ejercicio15;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OOBNB {
	private List<Usuario> usuarios;
	
	public OOBNB() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public Usuario registrarUsuario(String nombre, String direccion, int dni) {
		Usuario U = new Usuario(nombre,direccion,dni);
		this.usuarios.add(U);
		return U;
	}
	
	public List<Propiedad> buscarPropiedades(DateLapse periodo) {
		return this.usuarios.stream().flatMap(P -> P.buscarPropiedades(periodo).stream()).collect(Collectors.toList());
	}
	
	public List<Reserva> obtenerReserva(Usuario usuario) {
//		1) obtengo todas las propiedades 
//		2) obtengo todas las reservas del sistema
//		3) filtro por las que sean del man ese del parametro
		return this.usuarios.stream().flatMap(P -> P.ObtenerReserva(usuario).stream()).collect(Collectors.toList());
	}
	
	public double calcularIngresoDePropietario(Usuario usuario, DateLapse periodo) {
		return usuario.calcularIngreso(periodo);
	}
	
}
