package modelo;

import java.time.LocalDateTime;

public class Compra {
	private int cantidad;
	private Articulo articulo;
	private LocalDateTime fechaHora;

	public Compra(int cantidad, Articulo articulo, LocalDateTime fechaHora) throws Exception {
		super();
		setCantidad(cantidad);
		this.articulo = articulo;
		this.fechaHora = fechaHora;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws Exception {
		if (cantidad <= 0)
			throw new Exception("compra debe ser mayor a 0");
		this.cantidad = cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "Compra [cantidad=" + cantidad + ", articulo=" + articulo + ", fechaHora=" + fechaHora + "]\n";
	}

	public double aplicarDescuento(int cantidad, double precio) {
		double descuento = 0;
		if (getArticulo().getDescuento().isActivo())
			descuento = getArticulo().getDescuento().CalcularDescuentoParticular(cantidad, precio);
		return descuento;
	}

	public double precioTotal() {
		double descuento = aplicarDescuento(getCantidad(), getArticulo().getPrecio());
		return getArticulo().getPrecio() * getCantidad() - descuento;
	}
}
