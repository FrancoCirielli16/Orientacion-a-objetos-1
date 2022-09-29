package ar.edu.info.oo1.Ejercicio12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReporteDeContruccionTest {
	private ReporteDeContruccion reporteDeContruccio1;
	private Esfera esfera1;
	private Esfera esfera2;
	private Cilindro cilindro1;
	private Cilindro cilindro2;
	private PrismaRectangular prismaRectangular1;
	private PrismaRectangular prismaRectangular2;
	
	@BeforeEach
	void setUp() {
		this.reporteDeContruccio1 = new ReporteDeContruccion();
		this.cilindro1 = new Cilindro("Hierro", "Amarillo", 2,10);//125,66 -- //150,8
		this.cilindro2 = new Cilindro("Fibra","Negro",5,13);//1021.02 -- //565.49
		this.esfera1 = new Esfera("Hierro","Negro",3);//113.10 -- //113.10
		this.esfera2 = new Esfera("Fibra","Negro",5);//314.16 -- //523.60
		this.prismaRectangular1 = new PrismaRectangular("Hierro","Amarillo",10,5,20);//1000 -- //700
		this.prismaRectangular2 = new PrismaRectangular("Fibra","Negro",4,2,10); //80 -- //136
	}
	
	@Test
	void testVolumen() {
		assertEquals(0,this.reporteDeContruccio1.getVolumenDeMaterial("Hierro"));
		this.reporteDeContruccio1.agregarPieza(this.cilindro1);
		this.reporteDeContruccio1.agregarPieza(this.cilindro2);
		this.reporteDeContruccio1.agregarPieza(this.esfera1);
		this.reporteDeContruccio1.agregarPieza(this.esfera2);
		this.reporteDeContruccio1.agregarPieza(this.prismaRectangular1);
		this.reporteDeContruccio1.agregarPieza(this.prismaRectangular2);
		assertEquals(1210,this.reporteDeContruccio1.getVolumenDeMaterial("Hierro"),1);
	}
	
	@Test
	void testSuperficie() {
		assertEquals(0,this.reporteDeContruccio1.getSuperficieDeColor("Amarillo"));
		this.reporteDeContruccio1.agregarPieza(this.cilindro1);
		this.reporteDeContruccio1.agregarPieza(this.cilindro2);
		this.reporteDeContruccio1.agregarPieza(this.esfera1);
		this.reporteDeContruccio1.agregarPieza(this.esfera2);
		this.reporteDeContruccio1.agregarPieza(this.prismaRectangular1);
		this.reporteDeContruccio1.agregarPieza(this.prismaRectangular2);
		assertEquals(1128,this.reporteDeContruccio1.getSuperficieDeColor("Amarillo"),1);

	}

}
