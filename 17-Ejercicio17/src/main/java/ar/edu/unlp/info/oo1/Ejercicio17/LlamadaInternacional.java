package ar.edu.unlp.info.oo1.Ejercicio17;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada{
	private String paisOrigen;
	private String paisDestino;
	
	
	
	public LlamadaInternacional(LocalDateTime fecha, double duracion, String telefonoOrigen, String telefonoReceptor,
			String paisOrigen, String paisDestino) {
		super(fecha, duracion, telefonoOrigen, telefonoReceptor);
		this.paisOrigen = paisOrigen;
		this.paisDestino = paisDestino;
	}



	public double calcularCosto() {
//		if(getFecha().toLocalTime().isBefore(LocalTime.of(8,20)))
//				return super.calcularCosto(4);
//		 return super.calcularCosto(3); 
		
		return (getFecha().toLocalTime().isBefore(LocalTime.of(8,20)))
				? super.calcularCosto(4)
				: super.calcularCosto(3);
	}

}
