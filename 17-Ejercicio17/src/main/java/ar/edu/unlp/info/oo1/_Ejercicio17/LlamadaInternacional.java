package ar.edu.unlp.info.oo1._Ejercicio17;

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
//		if(getFecha().toLocalTime().isAfter(LocalTime.of(8,0)))
////		if ((this.getFecha().getHour() >= 8) && (this.getFecha().getMinute() >= 0) && (this.getFecha().getHour() < 20)) {
//			return super.calcularCosto(4);
//		}
//		else 
//			return super.calcularCosto(3); 
		return (getFecha().toLocalTime().isAfter(LocalTime.of(8,0)))
				? super.calcularCosto(4)
				: super.calcularCosto(3);
	}

}
