package ar.edu.info.oo1.Ejercicio11;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements inversion{
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	
	public PlazoFijo(LocalDate fechaDeConstitucion,double montoDepositado,double porcentajeDeInteresDiario){
		this.fechaDeConstitucion = fechaDeConstitucion;
		this.montoDepositado = montoDepositado;
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public double valorActual() {
		double dias = ChronoUnit.DAYS.between(this.fechaDeConstitucion,LocalDate.now());
		return this.montoDepositado+(this.montoDepositado*this.porcentajeDeInteresDiario*dias);
	}

}
