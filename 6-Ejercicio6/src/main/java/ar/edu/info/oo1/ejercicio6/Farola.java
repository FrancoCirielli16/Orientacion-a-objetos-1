package ar.edu.info.oo1.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Farola {
    private String marca;
    private int maximosCiclos;
    private int cantidadDeCiclos;
	private boolean isOn;
	private List<Farola> red;
	
		public boolean isOn() {
			return this.isOn;
		}
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	 public Farola (String fabricante, int cantidadDeCiclos){
        this.fabricante=fabricante;
        this.maximosCiclos=cantidadDeCiclos
		this.isOn=false;
		this.red= new ArrayList<Farola>();
	}
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	
	private void agregar(Farola otraFarola) {
		this.red.add(otraFarola);
	}
	
	public void pairWithNeighbor( Farola otraFarola ) {
		this.red.add(otraFarola);
		otraFarola.agregar(this);
	}
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.red;
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.isOn && !this.isCaducated()) {
			this.isOn = true;
            this.cantidadDeCiclos+=1;
			this.red.forEach(farola -> farola.turnOn());
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.isOn) {
			this.isOn = false;
			this.red.forEach(farola -> farola.turnOff());
		}
	}

	public boolean isCaducated() {
		return this.cantidadDeCiclos == this.maximosCiclos;
	}
    /*
    * Retorna una lista con las farolas que están en la red de la farola receptora y que poseen focos vencidos. Incluyendo el chequeo entre las farolas vecinas y las vecinas de estas propagando en toda la red.
    */
    public List<Farola> farolasConFocosVencidos() {
        return this.red.stream()
                .filter(f -> f.isCaducated())
                .toList();
    }


}