package ar.edu.unlp.info.oo1.Ejercicio16;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

	public class PoliticaModerada implements Politica {
		
		public double calcularRembolso(LocalDate fechaDeInicio, LocalDate fechaDeCancelacion, double monto) {
			if((int)fechaDeCancelacion.until(fechaDeInicio,ChronoUnit.DAYS)>2) {
					return monto;
				}
				else 	
					return monto / 2;
		}
}
