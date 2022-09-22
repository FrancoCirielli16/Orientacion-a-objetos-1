package ar.edu.info.oo1.Ejercicio7;

public class Empleado {
	private String nombre;
	
	
	public double montoBasico ( ) {
		return 35000 ;
	}
	
	public double aportes ( ) {
		return 13500 ;
	}
	
	public double sueldoBasico ( ) {
		return this . montoBasico () + this.aportes ( ) ; 
	}
	
	
}
