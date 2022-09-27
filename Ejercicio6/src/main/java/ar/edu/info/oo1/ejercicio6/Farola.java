package ar.edu.info.oo1.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean isOn;
	private List<Farola> Red;
	
		public boolean isOn() {
			return this.isOn;
		}
	/*
	* Crear una farola. Debe inicializarla como apagada
	*/
	public Farola () {
		this.isOn=false;
		this.Red= new ArrayList<Farola>();
	}
	/*
	* Crea la relación de vecinos entre las farolas. La relación de vecinos entre las farolas es recíproca, es decir el receptor del mensaje será vecino de otraFarola, al igual que otraFarola también se convertirá en vecina del receptor del mensaje
	*/
	
	private void agregar(Farola otraFarola) {
		this.Red.add(otraFarola);
	}
	
	public void pairWithNeighbor( Farola otraFarola ) {
		this.Red.add(otraFarola);
		otraFarola.agregar(this);
	}
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors (){
		return this.Red;
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.isOn) {
			this.isOn = true;
			this.Red.forEach(farola -> farola.turnOn());
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.isOn) {
			this.isOn = false;
			this.Red.forEach(farola -> farola.turnOff());
		}
	}

}
