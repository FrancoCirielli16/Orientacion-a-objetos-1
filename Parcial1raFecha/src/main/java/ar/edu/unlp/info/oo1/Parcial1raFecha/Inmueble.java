package ar.edu.unlp.info.oo1.Parcial1raFecha;

public class Inmueble implements Bien {
	private int nroPartida;
	private double valorLote;
	private double valorEdificacion;
	private Contribuyente propietario;
	
	public Inmueble(int nroPartida,double valorLote,double valorDeEdificacion,Contribuyente propietario) {
		this.nroPartida=nroPartida;
		this.valorLote=valorLote;
		this.valorEdificacion=valorDeEdificacion;
		this.propietario=propietario;
	}
	
	public Contribuyente getContribuyente() {
		return this.propietario;
	}
	
	public boolean esPropietario(Contribuyente propietario) {
		return this.propietario.equals(propietario);
	}
	
	public boolean esLocalidad(String localidad) {
		return this.propietario.esLocalidad(localidad);
	}
	
	@Override
	public double calcularMonto() {
		return this.valorLote+this.valorEdificacion;
	}

}
