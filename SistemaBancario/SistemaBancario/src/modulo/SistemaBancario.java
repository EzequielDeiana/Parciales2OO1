package modulo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaBancario {

	private List<Titular> lstTitulares;
	private List<CuentaBancaria> lstCuentasBancarias;
	
	public List<Titular> getLstTitulares() {
		return lstTitulares;
	}
	public void setLstTitulares(List<Titular> lstTitulares) {
		this.lstTitulares = lstTitulares;
	}
	public List<CuentaBancaria> getLstCuentasBancarias() {
		return lstCuentasBancarias;
	}
	public void setLstCuentasBancarias(List<CuentaBancaria> lstCuentasBancarias) {
		this.lstCuentasBancarias = lstCuentasBancarias;
	}
	
	public SistemaBancario() {
		super();
		this.lstTitulares = new ArrayList<Titular>();
		this.lstCuentasBancarias = new ArrayList<CuentaBancaria>();
	}
	
	//Metodos Titular
	
	public Titular traerTitular(long dni) {
		int i = 0;
		boolean encontrado = false;
		Titular aux = null;
		
		while(i < lstTitulares.size() && encontrado == false) {
			if(lstTitulares.get(i).getDni() == dni) {
				encontrado = true;
				aux = lstTitulares.get(i);
			}
			i++;
		}
		
		return aux;
	}
	
	public boolean agregarTitular(String nombre, String apellido, long dni) throws Exception{
		if(traerTitular(dni)  != null) {
			throw new Exception("Ya existe un titular con ese DNI");
		}
		return lstTitulares.add(new Titular(calcularProximoIDTitular(),nombre, apellido, dni));
	}
	
	private int calcularProximoIDTitular() {
		int id = 1;
		
		if(!lstTitulares.isEmpty()) {
			id = lstTitulares.get(lstTitulares.size()-1).getIdTitular()+1;
		}
		
		return id;
	}
	
	//Metodos cuenta
	
	public CuentaBancaria traerCuentaBancaria(String nroCuenta) {
		int i = 0;
		boolean encontrado = false;
		CuentaBancaria aux = null;
		
		while(i < lstCuentasBancarias.size() && encontrado == false) {
			if(lstCuentasBancarias.get(i).getNroCuenta().compareTo(nroCuenta) == 0) {
				encontrado = true;
				aux = lstCuentasBancarias.get(i);
			}
			i++;
		}
		
		return aux;
	}
	
	private boolean esFechaAltaValida(LocalDate fechaAlta){
		if(fechaAlta.isAfter(LocalDate.now())) {
			return false;
		}
		return true;
	}
	
	public boolean agregarCuentaCorriente(Titular titular, float saldo, String nroCuenta, LocalDate fechaAlta, boolean cobraSueldo, float costoMantenimiento, boolean esPremium) throws Exception{
		if(traerCuentaBancaria(nroCuenta) != null) {
			throw new Exception("Ya existe una Cuenta con este numero de cuenta");
		}
		if(!esFechaAltaValida(fechaAlta)) {
			throw new Exception("Fecha de alta Invalida");
		}
		return lstCuentasBancarias.add(new CuentaCorriente(calcularProximoIDCuentaBancaria(), titular, saldo, nroCuenta, fechaAlta, cobraSueldo, costoMantenimiento, esPremium));
	}
	
	public boolean agregarCuentaAhorro(Titular titular, double saldo, String nroCuenta, LocalDate fechaAlta, float limiteExtraccion) throws Exception{
		if(traerCuentaBancaria(nroCuenta) != null) {
			throw new Exception("Ya existe una Cuenta con este numero de cuenta");
		}
		return lstCuentasBancarias.add(new CuentaAhorro(calcularProximoIDCuentaBancaria(), titular, (float)saldo, nroCuenta, fechaAlta, limiteExtraccion));
	}
	
	private int calcularProximoIDCuentaBancaria() {
		int id = 1;
		
		if(!lstCuentasBancarias.isEmpty()) {
			id = lstCuentasBancarias.get(lstCuentasBancarias.size()-1).getIdCuentaBancaria()+1;
		}
		
		return id;
	}
	
	public List<CuentaBancaria> traerCuentasSinCostoMantenimientoEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta){
		List<CuentaBancaria> lstAux = new ArrayList<CuentaBancaria>();
		
		for (CuentaBancaria cuentaBancaria : lstCuentasBancarias) {
			if((cuentaBancaria.getFechaAlta().equals(fechaDesde)
					|| cuentaBancaria.getFechaAlta().isAfter(fechaDesde))
					&& (cuentaBancaria.getFechaAlta().isBefore(fechaHasta)
					|| cuentaBancaria.getFechaAlta().equals(fechaHasta))) {
				
				if(cuentaBancaria instanceof CuentaAhorro) {
					
					lstAux.add(cuentaBancaria);
					
				} else if(cuentaBancaria instanceof CuentaCorriente) {
					
					CuentaCorriente ccAux = (CuentaCorriente) cuentaBancaria;
					
					if(ccAux.isCobraSueldo()) {
						
						lstAux.add(cuentaBancaria);
					}
				}
			}
		}
		
		
		return lstAux;
	}
	
	public List<Titular> titularesConCuentaPremium(float saldoDesde, float saldoHasta){
		List<Titular> lstAux = new ArrayList<Titular>();
		
		for (CuentaBancaria cuentaBancaria : lstCuentasBancarias) {
			if((cuentaBancaria.getSaldo() == saldoDesde
					|| cuentaBancaria.getSaldo() > saldoDesde)
					&& (cuentaBancaria.getSaldo() < saldoHasta
					|| cuentaBancaria.getSaldo() == saldoHasta)) {
				lstAux.add(cuentaBancaria.getTitular());
			}
		}
		
		return lstAux;
	}
	
	public float previsionDeExtraccionTotal() {
		float total = 0;
		
		for (CuentaBancaria cuentaBancaria : lstCuentasBancarias) {
			total = total + cuentaBancaria.disponibleExtraccion();
		}
		
		return total;
	}
	
}
