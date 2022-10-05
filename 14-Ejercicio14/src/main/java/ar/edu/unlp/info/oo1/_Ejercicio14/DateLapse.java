package ar.edu.unlp.info.oo1._Ejercicio14;

import java.time.LocalDate;

import ar.edu.unlp.info.oo1._Ejercicio14T3.Fecha;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.time.temporal.ChronoUnit.YEARS;
public class DateLapse implements Fecha{
	private LocalDate to,from;
	
	public DateLapse(LocalDate to, LocalDate from) {
		this.to=to;
		this.from=from;
	}
	
	
	public LocalDate getFrom() {
		return this.from;
	}	
	//“Retorna la fecha de inicio del rango”
	public LocalDate getTo() {
		return this.to;
	}
	//“Retorna la fecha de fin del rango”
	
	public int sizeInDays() {
	//“retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
		return (int)this.from.until(this.to, DAYS);
	}
	
	public int sizeInYears() {
		return (int)this.from.until(this.to, YEARS);
	}
	
	public int sizeInMonths() {
		return (int)this.from.until(this.to, MONTHS);
	}
	
	public boolean includesDate(LocalDate other) {
		return other.isAfter(from) && other.isBefore(to);
	}
	//“recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
}
