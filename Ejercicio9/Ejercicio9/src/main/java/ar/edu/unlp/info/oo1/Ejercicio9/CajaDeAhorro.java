package ar.edu.unlp.info.oo1.Ejercicio9;

public class CajaDeAhorro extends Cuenta {
	
	public CajaDeAhorro() {
		super();
	}
		
	public void depositar(double monto) {
		super.depositar(monto - (monto*0.02));
	}
	
	public void extraerSaldo(double monto) {
		super.extraer(monto + (monto*0.02));
	}
	
	public void transferir(double monto,CajaDeAhorro cajaDeAhorro) {
		super.transferirACuenta(monto+(monto*0.02), cajaDeAhorro);
	}
	
	@Override
	public boolean puedeExtraer(double monto) {
		if(this.getSaldo()>=monto) {
			return true;
		}
		return false;
	}
	

}
