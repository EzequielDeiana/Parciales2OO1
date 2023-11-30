package modulo;

import java.time.LocalDate;

public class CuentaCorriente extends CuentaBancaria{
	
	private boolean cobraSueldo;
	private float costoMantenimiento;
	private boolean esPremium;
	
	public CuentaCorriente(int idCuentaBancaria, Titular titular, float saldo, String nroCuenta, LocalDate fechaAlta, boolean cobraSueldo, float costoMantenimiento, boolean esPremium) throws Exception {
		super(idCuentaBancaria, titular, saldo, nroCuenta, fechaAlta);
		this.cobraSueldo = cobraSueldo;
		this.costoMantenimiento = costoMantenimiento;
		this.esPremium = esPremium;
	}

	public boolean isCobraSueldo() {
		return cobraSueldo;
	}

	public void setCobraSueldo(boolean cobraSueldo) {
		this.cobraSueldo = cobraSueldo;
	}

	public float getCostoMantenimiento() {
		return costoMantenimiento;
	}

	public void setCostoMantenimiento(float costoMantenimiento) {
		this.costoMantenimiento = costoMantenimiento;
	}

	public boolean isEsPremium() {
		return esPremium;
	}

	public void setEsPremium(boolean esPremium) {
		this.esPremium = esPremium;
	}

	@Override
	public boolean esNumeroDeCuentaValido(String nroCuenta) throws Exception{
		if(nroCuenta.length() < 10 || !nroCuenta.startsWith("CC")) {
			throw new Exception("Error, numero de cuenta invalido");
		}
		return true;
	}
	
	@Override
	public float disponibleExtraccion() {
		float limite = 0;
		if(isEsPremium()) {
			limite = saldo;
		} else {
			limite = 200000;
		}
		return limite;
	}

	@Override
	public String toString() {
		return "CuentaCorriente [cobraSueldo=" + cobraSueldo + ", costoMantenimiento=" + costoMantenimiento
				+ ", esPremium=" + esPremium + ", idCuentaBancaria=" + idCuentaBancaria + ", titular=" + titular
				+ ", saldo=" + saldo + ", nroCuenta=" + nroCuenta + ", fechaAlta=" + fechaAlta + "]";
	}
	
	

}
