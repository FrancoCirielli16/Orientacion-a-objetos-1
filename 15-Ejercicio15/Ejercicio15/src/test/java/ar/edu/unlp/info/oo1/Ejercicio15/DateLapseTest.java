package ar.edu.unlp.info.oo1.Ejercicio15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseTest {
	DateLapse dl1= new DateLapse(LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 20));
	DateLapse dl2= new DateLapse(LocalDate.of(2022, 10, 9), LocalDate.of(2022, 10, 21));
	DateLapse dl3= new DateLapse(LocalDate.of(2022, 10, 11), LocalDate.of(2022, 10, 22));
	DateLapse dl4= new DateLapse(LocalDate.of(2022, 10, 9), LocalDate.of(2022, 10, 21));
	DateLapse dl5= new DateLapse(LocalDate.of(2022, 10, 12), LocalDate.of(2022, 10, 18));


	@Test
	void test() {
		assertTrue(dl1.OverLapse(dl1));

		assertTrue(dl1.OverLapse(dl2));
		assertTrue(dl1.OverLapse(dl3));
		assertTrue(dl1.OverLapse(dl4));
		assertTrue(dl1.OverLapse(dl5));

	}

}
