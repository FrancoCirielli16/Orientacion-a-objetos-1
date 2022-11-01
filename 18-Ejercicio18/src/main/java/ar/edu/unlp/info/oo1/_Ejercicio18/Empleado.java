package ar.edu.unlp.info.oo1._Ejercicio18;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Empleado {
	private String nombre;
	private String apellido;
	private int cuil;
	private LocalDate fechaDeNacimiento;
	private boolean tieneHijos;
	private boolean tieneConyuge;
	private List<Contrato> contratos;
	
	public Empleado(String nombre,String apellido,int cuil,LocalDate fechaDeNacimiento,boolean tieneHijos,boolean tieneConyuge) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.cuil=cuil;
		this.fechaDeNacimiento=fechaDeNacimiento;
		this.tieneHijos=tieneHijos;
		this.tieneConyuge=tieneConyuge;
		this.contratos= new ArrayList<Contrato>();	
		
	}
	
	public void cargarContratoPorHoras (LocalDate fechaDeInicio,LocalDate fechaDeVencimiento,double valorPorHora,int horasDeTrabajoPorMes) {
		ContratoPorHoras contrato = new ContratoPorHoras(this,fechaDeInicio,fechaDeVencimiento,valorPorHora,horasDeTrabajoPorMes);
		this.contratos.add(contrato);
	}
	
	public void cargarContratoDePlanta (LocalDate fechaDeInicio,double sueldoMensual,double montoAcordadoPorConyuge,double montoAcordadoPorHijos) {
		ContratoDePlanta contrato = new ContratoDePlanta(this,fechaDeInicio,sueldoMensual,montoAcordadoPorConyuge,montoAcordadoPorHijos);
		this.contratos.add(contrato);
	}
	
	public boolean tieneContratoVencido() {
		return this.contratoActual().map(c -> c.contratoVencido()).orElse(true);
	}
	
	private Optional<Contrato> contratoActual() {
		return this.contratos.stream().max((Contrato c1,Contrato c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio()));
	}
	
	public Recibo generarRecibo(){
		return new Recibo(this,this.antiguedad(),this.calcularMonto());
	}
	
	public int antiguedad() {
		return this.contratos.stream()
				.min((Contrato c1, Contrato c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio()))
				.map(contrato -> (int)ChronoUnit.YEARS.between (contrato.getFechaInicio(),LocalDate.now())).orElse(0);
	}
	
	public double calcularAumento() {
		if(this.antiguedad()==5) {
			return 0.3;
		}
		else 
			if(this.antiguedad()==10) {
				return 0.5;
			}
			else
				if(this.antiguedad()==15) {
					return 0.7;
				}
				else
					if(this.antiguedad()==20) {
						return 1;
					}
		return 0;
	}
	
	public double calcularMonto() {
		return this.contratoActual().map(c -> c.calcularMonto() * this.calcularAumento()).orElse(0d);
	}
	
	public boolean esEmpleado(int cuil) {
		return this.cuil == cuil; 
	}
	
	public boolean getTieneConyuge() {
		return this.tieneConyuge;
	}
	
	public boolean getTieneHijos() {
		return this.tieneHijos;
	}
}
