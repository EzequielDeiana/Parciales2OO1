package modelo;

public class descuentoPorCantidad extends Descuento {
	private int cadaNUnidades;
	private int UnidadesGratis;

	public descuentoPorCantidad(boolean activo, int cadaNUnidades, int unidadesGratis) {
		super(activo);
		this.cadaNUnidades = cadaNUnidades;
		UnidadesGratis = unidadesGratis;
	}

	public int getCadaNUnidades() {
		return cadaNUnidades;
	}

	public void setCadaNUnidades(int cadaNUnidades) {
		this.cadaNUnidades = cadaNUnidades;
	}

	public int getUnidadesGratis() {
		return UnidadesGratis;
	}

	public void setUnidadesGratis(int unidadesGratis) {
		UnidadesGratis = unidadesGratis;
	}

	@Override
	public String toString() {
		return "descuentoPorCantidad [cadaNUnidades=" + cadaNUnidades + ", UnidadesGratis=" + UnidadesGratis
				+ ", activo=" + activo + "]\n";
	}

	@Override
	protected double CalcularDescuentoParticular(int cantidad, double precio) {
		double descuento = 0;
		if (getUnidadesGratis() > 0)
			descuento = (cantidad / getCadaNUnidades() * getUnidadesGratis()) * precio;
		return descuento;
	}

}
