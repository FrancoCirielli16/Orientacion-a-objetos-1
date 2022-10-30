package ar.edu.unlp.info.oo1.Ejercicio16;

import java.time.LocalDate;
	public class PoliticaFlexible implements Politica {
		
		public double calcularRembolso(LocalDate fechaDeInicio, LocalDate fechaDeCancelacion, double monto) {
			if (fechaDeCancelacion.isBefore(fechaDeInicio)) {
				return monto;
	
			}
			return 0;
	}
}
