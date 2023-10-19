package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaYPF {

	private List<Tarjeta> tarjetas;

	public SistemaYPF() {
		super();
		this.tarjetas = new ArrayList<Tarjeta>();
	}
	
	// Metodos de TARJETA
	
	public boolean agregarTarjeta(String codigo, String codigoCliente) throws Exception {
		
		return getTarjetas().add((new Tarjeta(proximoIDTarjeta(), codigo, codigoCliente)));
		
	}
	
	public Tarjeta traerTarjeta(String codigoCliente) {
		
		Tarjeta encontrada = null;
		int i = 0;
		while (encontrada == null && i < getTarjetas().size()) {
			if(getTarjetas().get(i).getCodigoCliente().equals(codigoCliente)) {
				encontrada = getTarjetas().get(i);
			}
			i++;
		}
		
		return encontrada;
	}
	
	private int proximoIDTarjeta() {
		int id = 1;
		if (!getTarjetas().isEmpty()) {
			id = getTarjetas().get(getTarjetas().size()-1).getIdTarjeta()+1;
		}
		return id;
	}
	
	public List<Tarjeta> traerTarjetasComprasEfectivo(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Tarjeta> auxTarjetas = new ArrayList<Tarjeta>();
		
		for (Tarjeta tarjeta : getTarjetas()) {
			boolean usaEfectivo = false;
			for (Compra compra : tarjeta.getCompras()) {
				if(( compra.getFecha().isEqual(fechaHasta) || compra.getFecha().isBefore(fechaHasta)) &&
						(compra.getFecha().isAfter(fechaDesde) || compra.getFecha().isEqual(fechaDesde))) {
					if(compra instanceof Efectivo) {
						usaEfectivo = true;
					}
				}
			}
			if(usaEfectivo) {
				auxTarjetas.add(tarjeta);
			}
		}
		return auxTarjetas;
	}
	

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	
	
}
