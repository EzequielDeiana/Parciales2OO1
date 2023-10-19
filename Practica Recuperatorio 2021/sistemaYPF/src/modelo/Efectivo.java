package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Efectivo extends Compra{
	private double puntosExtra;
	
	protected Efectivo(LocalDate fecha, LocalTime hora, double puntosPorLitro, double litrosComprados, double puntosExtra) {
		super(fecha, hora, puntosPorLitro, litrosComprados);
		this.puntosExtra = puntosExtra;
	}

	public double getPuntosExtra() {
		return puntosExtra;
	}

	public void setPuntosExtra(double puntosExtra) {
		this.puntosExtra = puntosExtra;
	}

	@Override
	public double calcularPuntaje() {
		return (puntosPorLitro + puntosExtra) * litrosComprados;
	}
	
}
