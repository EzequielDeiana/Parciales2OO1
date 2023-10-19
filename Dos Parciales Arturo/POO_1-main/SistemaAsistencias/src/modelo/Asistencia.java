package modelo;

import java.time.LocalDate;

public abstract class Asistencia {
	protected int idAsistencia;
	protected LocalDate fecha;
	protected String legajo;

	protected Asistencia(LocalDate fecha, String legajo) {
		this.fecha = fecha;
		this.legajo = legajo;
	}

	// getters and setters
	public int getIdAsistencia() {
		return idAsistencia;
	}

	public void setIdAsistencia(int idAsistencia) {
		this.idAsistencia = idAsistencia;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public abstract double calcularHorasTrabajadas();

	@Override
	public String toString() {
		return "Asistencia [idAsistencia=" + idAsistencia + ", fecha=" + fecha + ", legajo=" + legajo + "]\n";
	}

}
