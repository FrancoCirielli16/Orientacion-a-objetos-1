package ar.edu.unlp.info.oo1._Ejercicio17;

import java.time.LocalDateTime;

public class LlamadaInterUrbana extends Llamada{
	private int distanciaEnKilometros;
	
	
	
	public LlamadaInterUrbana(LocalDateTime fecha, double duracion, String telefonoOrigen, String telefonoReceptor,
			int distanciaEnKilometros) {
		super(fecha, duracion, telefonoOrigen, telefonoReceptor);
		this.distanciaEnKilometros = distanciaEnKilometros;
	}



	public double calcularCosto() {
		if (this.distanciaEnKilometros<100) {
			return 5+super.calcularCosto(2);
		}
		else
			if (this.distanciaEnKilometros<=500) {
				return 5+super.calcularCosto(2.5);			
			}
			else
				return 5+super.calcularCosto(3);	
		}
				


}
