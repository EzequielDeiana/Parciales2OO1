package modulo;

import java.time.LocalDate;

public abstract class CuentaBancaria {
	protected int idCuentaBancaria;
	protected Titular titular;
	protected float saldo;
	protected String nroCuenta;
	protected LocalDate fechaAlta;
	
	public int getIdCuentaBancaria() {
		return idCuentaBancaria;
	}
	public void setIdCuentaBancaria(int idCuentaBancaria) {
		this.idCuentaBancaria = idCuentaBancaria;
	}
	public Titular getTitular() {
		return titular;
	}
	public void setTitular(Titular titular) {
		this.titular = titular;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(String nroCuenta) throws Exception {
		esNumeroDeCuentaValido(nroCuenta);
		this.nroCuenta = nroCuenta;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	public CuentaBancaria(int idCuentaBancaria, Titular titular, float saldo, String nroCuenta, LocalDate fechaAlta) throws Exception {
		super();
		this.idCuentaBancaria = idCuentaBancaria;
		this.titular = titular;
		this.saldo = saldo;
		setNroCuenta(nroCuenta);
		this.fechaAlta = fechaAlta;
	}
	
	public abstract float disponibleExtraccion();
	
	public abstract boolean esNumeroDeCuentaValido(String nroCuenta) throws Exception;
	
}
