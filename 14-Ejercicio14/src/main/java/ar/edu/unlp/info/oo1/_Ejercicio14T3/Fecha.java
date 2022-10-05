package ar.edu.unlp.info.oo1._Ejercicio14T3;

import java.time.LocalDate;

public interface Fecha {

	public LocalDate getFrom();

	public LocalDate getTo();

	public int sizeInDays();

	public boolean includesDate(LocalDate other);


}
