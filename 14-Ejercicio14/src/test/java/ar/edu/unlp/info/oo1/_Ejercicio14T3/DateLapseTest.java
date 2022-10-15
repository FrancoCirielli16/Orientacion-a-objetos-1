package ar.edu.unlp.info.oo1._Ejercicio14T3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateLapseTest {
	private DateLapse date;
	private LocalDate from,to,fechaAComparar;
	
	@BeforeEach
	public void setUp() {
		this.from=LocalDate.of(2020, 5, 5);
		this.to=LocalDate.of(2022, 12, 16);
		this.fechaAComparar=LocalDate.of(2022, 10, 5);
		this.date=new DateLapse(this.from,955);
	}
	

	@Test
	public void getFromTest() {
		assertEquals(this.from,this.date.getFrom());
	}
	
	@Test
	public void getToTest() {
		assertEquals(this.to,this.date.getTo());
	}
	
	@Test
	public void sizeInDaysTest() {
		assertEquals(955,this.date.sizeInDays());
	}
	
	@Test
	public void includesDateTest(){
		assertTrue(this.date.includesDate(fechaAComparar));
	}
}
