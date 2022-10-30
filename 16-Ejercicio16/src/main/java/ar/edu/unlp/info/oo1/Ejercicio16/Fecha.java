package ar.edu.unlp.info.oo1.Ejercicio16;

import java.time.LocalDate;

public interface Fecha {

	public LocalDate getFrom();

	public LocalDate getTo();

	public int sizeInDays();

	public boolean includesDate(LocalDate other);


}
