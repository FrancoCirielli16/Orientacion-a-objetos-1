package ar.edu.unlp.info.oo1._Ejercicio14T3;

import java.time.LocalDate;

public class DateLapse implements Fecha{
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapse(LocalDate from,int sizeInDays) {
		this.from=from;
		this.sizeInDays=sizeInDays;
	}
	
	public LocalDate getTo() {
		return this.from.plusDays(this.sizeInDays);
	}
	
	public LocalDate getFrom() {
		return this.from;
	}
	
	public int sizeInDays() {
		return this.sizeInDays;
	}	
	
	public boolean includesDate(LocalDate other) {
		return other.isEqual(from) || other.isEqual(this.getTo()) && other.isAfter(from) && other.isBefore(this.getTo());
	}
	//“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.

}
