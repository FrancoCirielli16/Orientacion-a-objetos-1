package ar.edu.info.oo1.Ejercicio5;

import java.sql.Date;
import java.time.LocalDate;

public class Mamifero {
	private String especie;
	private String identificador;
	private Date fechaDeNacimiento;
	private Mamifero padre;
	private Mamifero madre;

	
	public Mamifero() {
		
	}
	
	public Mamifero(String id) {
		this.identificador = id;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especies) {
		this.especie = especies;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbuelaMaterna() {
		if (this.madre != null) {
			return this.madre.getMadre();
		}
		return null;
	}
	
	public Mamifero getAbueloMaterno() {
		if (this.madre != null) {
			return this.madre.getPadre();
		}
		return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if (this.padre !=null){
			return this.padre.getMadre();
		}
		return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if (this.padre != null) {
		return this.padre.getPadre();
		}
		return null;
	}
	
	
	public boolean tieneComoAncestroA(Mamifero M){
		return (this.padre == M || 
				this.madre == M || 
				(this.padre != null && this.padre.tieneComoAncestroA(M)) || 
				(this.madre != null && this.madre.tieneComoAncestroA(M)));  
	}
}