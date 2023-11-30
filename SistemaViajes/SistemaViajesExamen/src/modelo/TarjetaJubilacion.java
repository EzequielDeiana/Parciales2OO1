package modelo;

public class TarjetaJubilacion extends Tarjeta{

	private double porcentajeDeDescuento;
	
	public TarjetaJubilacion(String codigo, int id, boolean descuentoActivo, double porcentajeDeDescuento) {
		super(codigo, id, descuentoActivo);
		this.porcentajeDeDescuento = porcentajeDeDescuento;
	}

	public double getPorcentajeDeDescuento() {
		return porcentajeDeDescuento;
	}

	public void setPorcentajeDeDescuento(double porcentajeDeDescuento) {
		this.porcentajeDeDescuento = porcentajeDeDescuento;
	}

	@Override
	public double calcularDescuento(double precio) {
		
		double descuento = (porcentajeDeDescuento / 100) * precio;
		
		return descuento;
	}

	@Override
	public String toString() {
		return "TarjetaJubilacion [porcentajeDeDescuento=" + porcentajeDeDescuento + ", codigo=" + codigo + ", id=" + id
				+ "]";
	}
	
	
	
}
