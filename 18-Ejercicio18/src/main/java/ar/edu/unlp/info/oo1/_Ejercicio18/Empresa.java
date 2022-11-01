package ar.edu.unlp.info.oo1._Ejercicio18;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Empresa {
	private List<Empleado> empleados;
	
	
	public Empresa() {
		this.empleados = new ArrayList<Empleado>();
	}
	
	public Empleado darAltaEmpleado(String nombre,String apellido,int cuil, LocalDate fechaNacimiento,LocalDate fechaDeIngreso,boolean tieneHijos,boolean tieneConyuge) {
		Empleado e = new Empleado(nombre,apellido,cuil,fechaNacimiento,fechaDeIngreso,tieneHijos,tieneConyuge);
		this.empleados.add(e);
		return e;
	}
	
	public boolean darBajaEmpleado(Empleado empleado) {
		return this.empleados.remove(empleado);
	}
	
	public Empleado buscarEmpleado(int cuil) {
		return this.empleados.stream().filter(e -> e.esEmpleado(cuil)).findFirst().orElse(null);		
	}
	
	public List<Empleado> obtenerEmpleadosConContratoVencido(){
		return this.empleados.stream().filter(e -> e.tieneContratoVencido()).collect(Collectors.toList());
	}
	
	public List<Recibo> generarRecibos(){
		return this.empleados.stream().map(empleado -> empleado.generarRecibo()).collect(Collectors.toList());
	}
}
