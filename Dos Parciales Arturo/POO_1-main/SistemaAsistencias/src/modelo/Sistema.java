package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Asistencia> asistencias;

	public Sistema() {
		this.asistencias = new ArrayList<>();
	}

	public boolean agregarTrabajoPresencial(LocalDate fecha, String legajo, LocalTime horaDesde, LocalTime HoraHasta)
			throws Exception {

		if (traerAsistencia(fecha, legajo) != null)
			throw new Exception("ya existe " + legajo + " con fecha " + fecha);
		TrabajoPresencial nuevoTPres = new TrabajoPresencial(fecha, legajo, horaDesde, HoraHasta);
		nuevoTPres.setIdAsistencia(nuevoID());
		return asistencias.add(nuevoTPres);
	}

	private int nuevoID() {
		int nuevoID = 1;
		if (!asistencias.isEmpty())
			nuevoID = asistencias.get(asistencias.size() - 1).getIdAsistencia() + 1;
		return nuevoID;
	}

	public boolean agregarTeletrabajo(LocalDate fecha, String legajo, String motivo, int tareasRealizadas)
			throws Exception {
		Teletrabajo nuevoT = new Teletrabajo(fecha, legajo, motivo, tareasRealizadas);
		nuevoT.setIdAsistencia(nuevoID());
		return asistencias.add(nuevoT);
	}

	public Asistencia traerAsistencia(LocalDate fecha, String legajo) {
		Asistencia encontrada = null;
		List<Asistencia> auxLista = traerAsistencia(fecha);
		int i = 0;
		while (encontrada == null && i < auxLista.size()) {
			if (auxLista.get(i).getLegajo().equals(legajo) && auxLista.get(i).getFecha().equals(fecha))
				encontrada = auxLista.get(i);
			i++;
		}
		return encontrada;
	}

	public List<Asistencia> traerAsistencia(LocalDate fecha) {

		List<Asistencia> encontradas = new ArrayList<>();
		for (Asistencia asistencia : asistencias) {
			if (asistencia.getFecha().equals(fecha))
				encontradas.add(asistencia);
		}
		return encontradas;
	}

	public List<Asistencia> traerAsistencia(boolean esPresencial) {
		List<Asistencia> encontradas = new ArrayList<>();
		for (Asistencia asistencia : asistencias) {
			if (esPresencial && esPresencial(asistencia))
				encontradas.add(asistencia);
			else if (!esPresencial && !esPresencial(asistencia))
				encontradas.add(asistencia);
		}
		return encontradas;
	}

	private boolean esPresencial(Asistencia asistencia) {
		return asistencia instanceof TrabajoPresencial;
	}

	@Override
	public String toString() {
		return "Sistema [asistencias=" + asistencias + "]";
	}

}
