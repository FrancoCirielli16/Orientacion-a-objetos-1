package ar.edu.unlp.info.oo1.Ejercicio16;

import java.time.LocalDate;

public interface Politica {
	
	double calcularRembolso(LocalDate fechaDeInicio, LocalDate fechaDeCancelacion, double monto);
}
