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
	private LocalDate fechaDeIngreso;
	private boolean tieneHijos;
	private boolean tieneConyuge;
	private List<Contrato> contratos;
	
//	public Empleado(String nombre,String apellido,int cuil,LocalDate fechaDeNacimiento,boolean tieneHijos,boolean tieneConyuge) {
//		this.nombre=nombre;
//		this.apellido=apellido;
//		this.cuil=cuil;
//		this.fechaDeNacimiento=fechaDeNacimiento;
//		this.fechaDeIngreso= LocalDate.now();
//		this.tieneHijos=tieneHijos;
//		this.tieneConyuge=tieneConyuge;
//		this.contratos= new ArrayList<Contrato>();	
//		
//	}
//	Hago un constructo para testear (solo este caso)
	public Empleado(String nombre,String apellido,int cuil,LocalDate fechaDeNacimiento,LocalDate fechaDeIngreso,boolean tieneHijos,boolean tieneConyuge) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.cuil=cuil;
		this.fechaDeNacimiento=fechaDeNacimiento;
		this.fechaDeIngreso= fechaDeIngreso;
		this.tieneHijos=tieneHijos;
		this.tieneConyuge=tieneConyuge;
		this.contratos= new ArrayList<Contrato>();	
		
	}
	
	public ContratoPorHoras cargarContratoPorHoras (LocalDate fechaDeInicio,LocalDate fechaDeVencimiento,double valorPorHora,int horasDeTrabajoPorMes) {
		//if(this.tieneContratoVencido() && fechaDeInicio.isAfter(LocalDate.now())) { //verifico si la fecha de inicio del contrato es correcta
		if(this.tieneContratoVencido()) {
			ContratoPorHoras contrato = new ContratoPorHoras(this,fechaDeInicio,fechaDeVencimiento,valorPorHora,horasDeTrabajoPorMes);
			this.contratos.add(contrato);
			return contrato;
		}
		return null;
	}
	
	public ContratoDePlanta cargarContratoDePlanta (LocalDate fechaDeInicio,double sueldoMensual,double montoAcordadoPorConyuge,double montoAcordadoPorHijos) {
		if(this.tieneContratoVencido()) {
			ContratoDePlanta contrato = new ContratoDePlanta(this,fechaDeInicio,sueldoMensual,montoAcordadoPorConyuge,montoAcordadoPorHijos);
			this.contratos.add(contrato);
			return contrato;
		}
		return null;
	}
	
	public boolean tieneContratoVencido() {
		if (this.contratoActual() == null) {
			return true;
		}
		return this.contratoActual().contratoVencido();
	}
	
	private Contrato contratoActual() {
		return this.contratos.stream().max((Contrato c1,Contrato c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio())).orElse(null);
	}
	
	public Recibo generarRecibo(){
		return new Recibo(this,this.antiguedad(),this.calcularMonto());
	}
	
	public int antiguedad() {
		return (int)ChronoUnit.YEARS.between(this.fechaDeIngreso, LocalDate.now()); // calculo incorrecto para antiguedad
	}
	
	public double calcularAumento() {
		if((this.antiguedad()>=5) && (this.antiguedad()<10)) {
			return 0.3;
		}
		else 
			if((this.antiguedad()>=10)&&(this.antiguedad()<15)) {
				return 0.5;
			}
			else
				if((this.antiguedad()>=15)&&(this.antiguedad()<20)) {
					return 0.7;
				}
				else
					if(this.antiguedad()>20){
						return 1;
					}
		return 0;
	}
	
	public double calcularMonto() {
		double monto = this.contratoActual().calcularMonto();
		return monto + monto * this.calcularAumento();
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
