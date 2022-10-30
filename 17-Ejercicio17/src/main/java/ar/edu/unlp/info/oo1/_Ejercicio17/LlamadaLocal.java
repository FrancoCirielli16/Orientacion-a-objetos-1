package ar.edu.unlp.info.oo1._Ejercicio17;

import java.time.LocalDateTime;

public class LlamadaLocal extends Llamada{
	
	public LlamadaLocal (LocalDateTime fecha, double duracion, String telefonoOrigen, String telefonoReceptor) {
		super(fecha,duracion,telefonoOrigen,telefonoReceptor);
	}
	
	public double calcularCosto() {
		return super.calcularCosto(1);
	}
}
