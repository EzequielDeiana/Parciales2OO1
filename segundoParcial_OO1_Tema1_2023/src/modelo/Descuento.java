package modelo;

public abstract class Descuento {

	protected boolean activo;

	public Descuento(boolean activo) {
		super();
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Descuento [activo=" + activo + "]\n";
	}

	protected abstract double CalcularDescuentoParticular(int cantidad, double precio);
}
