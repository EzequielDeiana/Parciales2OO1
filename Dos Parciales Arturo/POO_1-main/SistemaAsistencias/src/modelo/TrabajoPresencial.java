package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class TrabajoPresencial extends Asistencia {
	private LocalTime horaDesde;
	private LocalTime horaHasta;

	public TrabajoPresencial(LocalDate fecha, String legajo, LocalTime horaDesde, LocalTime horaHasta) {
		super(fecha, legajo);
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
	}

	@Override
	public double calcularHorasTrabajadas() {
		int horas = horaHasta.getHour() - horaDesde.getHour();
		int minutos = horaHasta.getMinute() - horaDesde.getMinute();
		if (minutos < 0) {
			horas--;
			minutos += 60;
		}
		return ((horas * 60 + minutos) / 60f);
	}

	@Override
	public String toString() {
		return "TrabajoPresencial [horaDesde=" + horaDesde + ", horaHasta=" + horaHasta + ", toString()="
				+ super.toString() + "]";
	}

}
