package modelo;

public class DescuentoPorSubTotal extends Descuento {
	private int aplicarDesdeValor;
	private int porcentajeDescuento;

	public DescuentoPorSubTotal(boolean activo, int aplicarDesdeValor, int porcentajeDescuento) {
		super(activo);
		this.aplicarDesdeValor = aplicarDesdeValor;
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public int getAplicarDesdeValor() {
		return aplicarDesdeValor;
	}

	public void setAplicarDesdeValor(int aplicarDesdeValor) {
		this.aplicarDesdeValor = aplicarDesdeValor;
	}

	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(int porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public String toString() {
		return "DescuentoPorSubTotal [aplicarDesdeValor=" + aplicarDesdeValor + ", porcentajeDescuento="
				+ porcentajeDescuento + ", activo=" + activo + "]\n";
	}

	@Override
	protected double CalcularDescuentoParticular(int cantidad, double precio) {
		double descuento = 0;
		if ((cantidad * precio) >= getAplicarDesdeValor())
			descuento = (cantidad * precio) * (getPorcentajeDescuento() / 100D);

		return descuento;
	}
}
