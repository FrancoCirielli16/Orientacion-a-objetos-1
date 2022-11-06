package ar.edu.unlp.info.oo1.Parcial1raFecha;

public interface Bien {
	
	double calcularMonto();

	boolean esPropietario(Contribuyente propietario);
	
	Contribuyente getContribuyente();
	
	boolean esLocalidad(String Localidad);
	
}
