package modelo;

public class TarjetaEstudiantil extends Tarjeta{

	private double saldoAFavor;
	
	public TarjetaEstudiantil(int id, String codigo, boolean descuentoActivo, double saldoAFavor) {
		super(codigo, id, descuentoActivo);
		this.saldoAFavor = saldoAFavor;
	}

	public double getSaldoAFavor() {
		return saldoAFavor;
	}

	public void setSaldoAFavor(double saldoAFavor) {
		this.saldoAFavor = saldoAFavor;
	}

	@Override
	public double calcularDescuento(double precio) {
		double descuento = 0;
		if(precio <= saldoAFavor) {
			descuento = precio;
			saldoAFavor -= precio;
		}else if (precio > saldoAFavor) {
			descuento = saldoAFavor;
			saldoAFavor = 0;
		}
		return descuento;
	}

	@Override
	public String toString() {
		return "TarjetaEstudiantil [saldoAFavor=" + saldoAFavor + ", codigo=" + codigo + ", id=" + id + "]";
	} 
	
	
	
}
