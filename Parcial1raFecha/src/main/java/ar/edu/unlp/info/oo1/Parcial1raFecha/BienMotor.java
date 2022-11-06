package ar.edu.unlp.info.oo1.Parcial1raFecha;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class BienMotor implements Bien {
	private String patente;
	private LocalDate fechaDeFabricacion;
	private double valor;
	private Contribuyente propietario;
	
	
	public BienMotor(String patente, LocalDate fechaDeFabricacion, double valor, Contribuyente propietario) {
		this.patente = patente;
		this.fechaDeFabricacion = fechaDeFabricacion;
		this.valor = valor;
		this.propietario = propietario;
	}
	
	public boolean supera10Años() {
		return (ChronoUnit.YEARS.between(this.fechaDeFabricacion,LocalDate.now())>10); 
	}
	
	public boolean esPropietario(Contribuyente propietario) {
		return this.propietario.getNombre() == propietario.getNombre();
	}
	
	public boolean esLocalidad(String localidad) {
		return this.propietario.esLocalidad(localidad);
	}
	
	public Contribuyente getContribuyente() {
		return this.propietario;
	}
	
	public boolean superaMillon() {
		return this.valor > 1000000;
	}
	
	public double calcularMonto(double porcentaje) {
		return this.valor+this.valor*porcentaje;
	}
}
