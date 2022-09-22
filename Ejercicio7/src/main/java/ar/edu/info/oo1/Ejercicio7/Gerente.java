package ar.edu.info.oo1.Ejercicio7;

public class Gerente extends EmpleadoJerarquico {
	
	public double aportes() {
		return this.montoBasico() * 0.05d ;
	}
	
	public double montoBasico() {
		return 57000 ;
	}
}
