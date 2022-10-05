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
		return other.isAfter(from) && other.isBefore(this.getTo());
	}
}
