package ar.edu.unlp.info.oo1.Ejercicio2;

public class Balanza {
	private int cantidadProductos;
	private double precioTotal;
	private double pesoTotal;

	
	public void ponerEnCero() {
		this.cantidadProductos = 0;
		this.pesoTotal = 0;
		this.precioTotal = 0;
	}
		
	public void agregarProducto(Producto P) {
		this.cantidadProductos++;
		this.pesoTotal = this.pesoTotal + P.getPeso();
		this.precioTotal = this.precioTotal + P.getPrecio();
			
	}
	
	public Ticket emitirTicket() {
		Ticket T = new Ticket(this.cantidadProductos,this.pesoTotal,this.precioTotal);
		return T;
	}
	
	
	public double getPesoTotal() {
		return this.pesoTotal;
	}
	
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	public int getCantidadDeProductos() {
		return this.cantidadProductos;
	}
}
