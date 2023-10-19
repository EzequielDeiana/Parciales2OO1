package modelo;

import java.time.LocalDate;

public class Teletrabajo extends Asistencia {
	private String motivo;
	private int tareasRealizadas;

	public Teletrabajo(LocalDate fecha, String legajo, String motivo, int tareasRealizadas) throws Exception {
		super(fecha, legajo);
		this.motivo = motivo;
		setTareasRealizadas(tareasRealizadas);
	}

	@Override
	public double calcularHorasTrabajadas() {
		return tareasRealizadas * 1.5;
	}

	@Override
	public String toString() {
		return "Teletrabajo [motivo=" + motivo + ", tareasRealizadas=" + tareasRealizadas + ", toString()="
				+ super.toString() + "]";
	}

	public int getTareasRealizadas() {
		return tareasRealizadas;
	}

	public void setTareasRealizadas(int tareasRealizadas) throws Exception {
		if (tareasRealizadas > 8)
			throw new Exception("solo se admiten hasta 8 tareas");
		this.tareasRealizadas = tareasRealizadas;
	}

}
