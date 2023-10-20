package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaDistribuidora {
	
	private List<Tarifa> lstTarifa;
	private List<Lectura> lstLectura;
	private List<Cliente> lstCliente;
	
	public SistemaDistribuidora() {
		super();
		this.lstTarifa = new ArrayList<Tarifa>();
		this.lstLectura = new ArrayList<Lectura>();
		this.lstCliente = new ArrayList<Cliente>();
	}
	
	
	//Metodos Cliente
	
	public boolean agregarCliente(long numeroCliente, String nombre, String apellido, int dni, int kWSubsidio) {
		return getLstCliente().add(new ClienteResidencial(getProximoIDCliente(), numeroCliente, nombre, apellido, dni, kWSubsidio));
	}
	
	public boolean agregarCliente(long numeroCliente, long cuit, String razonSocial) {
		return getLstCliente().add(new ClienteCorporativo(getProximoIDCliente(), numeroCliente, cuit, razonSocial));
	}
	
	
	public Cliente traerCliente(long numeroCliente) {
		int i = 0;
		boolean encontrado = false;
		Cliente aux = null;
		
		while(i < getLstCliente().size() && encontrado == false) {
			if(getLstCliente().get(i).numeroCliente == numeroCliente) {
				encontrado = true;
				aux = getLstCliente().get(i);
			}
			i++;
		}
		
		return aux;
	}
	
	
	private int getProximoIDCliente() {
		int id = 1;
		
		if(!getLstCliente().isEmpty()) {
			id = getLstCliente().get(getLstCliente().size()-1).getId()+1;
		}
		
		return id;
	}
	
	//Metodos de Tarifa
	
	public boolean agregarTarifa(int consumoDesde, int consumoHasta, float cargoFijo, float cargoVariable) {
		return getLstTarifa().add(new Tarifa(getProximoIDTarifa(), consumoDesde, consumoHasta, cargoFijo, cargoVariable));
	}
	
	public Tarifa traerTarifa(int consumo) {
		int i = 0;
		boolean encontrado = false;
		Tarifa aux = null;
		
		while(i < getLstTarifa().size() && encontrado == false) {
			if(getLstTarifa().get(i).getConsumoDesde() <= consumo && getLstTarifa().get(i).getConsumoHasta() >= consumo) {
				encontrado = true;
				aux = getLstTarifa().get(i);
			}
			i++;
		}
		
		return aux;
	}
	
	private int getProximoIDTarifa() {
		int id = 1;
		
		if(!getLstTarifa().isEmpty()) {
			id = getLstTarifa().get(getLstTarifa().size()-1).getId()+1;
		}
		
		return id;
	}
	
	//Metodos de Lectura
	
	public boolean agregarLectura(LocalDate fecha, Cliente cliente, int estadoMedidor) {
		return getLstLectura().add(new Lectura(getProximoIDLectura(), fecha, cliente, estadoMedidor));
	}
	
	public Lectura traerLectura(int mes, int anio, Cliente cliente) {
		int i = 0;
		boolean encontrado = false;
		Lectura aux = null;
		
		while(i < getLstLectura().size() && encontrado == false) {
			if(getLstLectura().get(i).getCliente().equals(cliente)) {
				if(getLstLectura().get(i).getFecha().getMonthValue() == mes && getLstLectura().get(i).getFecha().getYear() == anio){
				aux = getLstLectura().get(i);
				encontrado = true;
			}
			}
			i++;
		}
		
		return aux;
	}
	
	
	private int getProximoIDLectura() {
		int id = 1;
		
		if(!getLstLectura().isEmpty()) {
			id = getLstLectura().get(getLstLectura().size()-1).getId()+1;
		}
		
		return id;
	}
	
	//Total a Cobrar
	public float calcularTotalACobrar(int mes, int anio, Cliente cliente) {
		Lectura lectura1 = traerLectura(mes, anio, cliente);
	    Lectura lectura2 = traerLectura(traerLectura(mes, anio, cliente).getFecha().minusMonths(1).getMonth().getValue(), anio-1, cliente);
	    
	    int consumoEntreLectura = lectura1.calcularConsumo(lectura2);
	    Tarifa tarifa = traerTarifa(consumoEntreLectura);
	    float totalVariable = tarifa.getCargoVariable() * consumoEntreLectura;
	    
	    if(cliente instanceof ClienteResidencial){
	    	ClienteResidencial aux = (ClienteResidencial) cliente;
	    	if(aux.getkWhSubsidio() > 0) {
	    		float descuento = tarifa.getCargoVariable() * aux.getkWhSubsidio();
	    		if(totalVariable >= descuento) {
	    			totalVariable = totalVariable - descuento;
	    		} else {
	    			totalVariable = 0;
	    		}
	    	}
	    }
	    return tarifa.getCargoFijo()-totalVariable;
	}
	
	public List<Tarifa> getLstTarifa() {
		return lstTarifa;
	}
	public void setLstTarifa(List<Tarifa> lstTarifa) {
		this.lstTarifa = lstTarifa;
	}
	public List<Lectura> getLstLectura() {
		return lstLectura;
	}
	public void setLstLectura(List<Lectura> lstLectura) {
		this.lstLectura = lstLectura;
	}
	public List<Cliente> getLstCliente() {
		return lstCliente;
	}
	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	
	
	
}
