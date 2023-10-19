package modelo;

import java.time.LocalDateTime;

public class Viaje {
	private Tarjeta tarjeta;
	private String linea;
	private String medio;
	private LocalDateTime fechaHoraViaje;
	private double precio;

	public Viaje(Tarjeta tarjeta, String linea, String medio, LocalDateTime fechaHoraViaje, double precio) {
		super();
		this.tarjeta = tarjeta;
		this.linea = linea;
		this.medio = medio;
		this.fechaHoraViaje = fechaHoraViaje;
		this.precio = precio;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public LocalDateTime getFechaHoraViaje() {
		return fechaHoraViaje;
	}

	public void setFechaHoraViaje(LocalDateTime fechaHoraViaje) {
		this.fechaHoraViaje = fechaHoraViaje;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Viaje [" + tarjeta + ", ln:" + linea + ", medio:" + medio + ", fechaHr: " + fechaHoraViaje + ", precio="
				+ precio + "]\n";
	}

	public double totalAPagar() {
		double subTtal = getPrecio();
		if (getTarjeta().getUsuario().isTieneDescuento())
			subTtal -= getPrecio() * 0.15;

		return subTtal;
	}

}
