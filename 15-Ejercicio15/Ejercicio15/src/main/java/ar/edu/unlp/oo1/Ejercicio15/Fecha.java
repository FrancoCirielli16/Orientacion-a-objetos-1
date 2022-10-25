package ar.edu.unlp.oo1.Ejercicio15;

import java.time.LocalDate;

public interface Fecha {

	public LocalDate getFrom();

	public LocalDate getTo();

	public int sizeInDays();

	public boolean includesDate(LocalDate other);


}
