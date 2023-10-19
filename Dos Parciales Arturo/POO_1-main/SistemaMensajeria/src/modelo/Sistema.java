package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Mensaje> listaMensajes;

	public Sistema() {
		this.listaMensajes = new ArrayList<Mensaje>();
	}

	public boolean agregarSMS(LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino,
			String texto, OperadorMovil operadorOrigen, OperadorMovil operadorDestino) throws Exception {
		SMS nuevoSMS = new SMS(fechaEnvio, horaEnvio, numeroOrigen, numeroDestino, texto, operadorOrigen,
				operadorDestino); // El atributo visto se inicializará por defecto en falso
		nuevoSMS.setIdMensaje(nuevoID());
		return listaMensajes.add(nuevoSMS);
	}

	public boolean agregarEmail(LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino, String asunto,
			String cuerpo) throws Exception { // El atributo recibido se inicializará por defecto en falso.
		Email nuevoEmail = new Email(fechaEnvio, horaEnvio, origen, destino, asunto, cuerpo);
		nuevoEmail.setIdMensaje(nuevoID());
		return listaMensajes.add(nuevoEmail);
	}

	private int nuevoID() {
		int nuevoID = 1;
		if (!listaMensajes.isEmpty())
			nuevoID = listaMensajes.get(listaMensajes.size() - 1).getIdMensaje() + 1;
		return nuevoID;
	}

	public Mensaje traerMensaje(int idMensaje) {
		Mensaje encontrado = null;
		int i = 0;

		while (encontrado == null && i < listaMensajes.size()) {
			if (listaMensajes.get(i).getIdMensaje() == idMensaje)
				encontrado = listaMensajes.get(i);
			i++;
		}
		return encontrado;
	}

	public List<Mensaje> traerMensaje(String nombreCompania) {
		List<Mensaje> encontrados = new ArrayList<Mensaje>();

		for (Mensaje mensaje : listaMensajes) {
			if (traeCompañia(mensaje) != null && traeCompañia(mensaje).equals(nombreCompania))
				encontrados.add(mensaje);
		}
		return encontrados;
	}

	private String traeCompañia(Mensaje mensaje) {
		String nombre = null;
		if (mensaje instanceof SMS)
			nombre = ((SMS) mensaje).getOperadorOrigen().getCompaniaMovil();
		return nombre;
	}

	public List<Mensaje> traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta) {
		List<Mensaje> encontrados = new ArrayList<Mensaje>();

		for (Mensaje mensaje : listaMensajes) {
			if (mensaje.getFechaEnvio().equals(fecha))
				if ((mensaje.getHoraEnvio().equals(horaDesde) || mensaje.getHoraEnvio().isAfter(horaDesde))
						&& (mensaje.getHoraEnvio().equals(horaHasta) || mensaje.getHoraEnvio().isBefore(horaHasta)))

					encontrados.add(mensaje);
		}
		return encontrados;
	}

	public List<Mensaje> traerMensaje(LocalDate fecha, LocalTime horaDesde, LocalTime horaHasta,
			String nombreCompania) {

		List<Mensaje> encontrados = new ArrayList<Mensaje>();
		List<Mensaje> listaFecha = traerMensaje(fecha, horaDesde, horaHasta);

		for (Mensaje mensaje : listaFecha) {
			if (traeCompañia(mensaje).equals(nombreCompania))
				encontrados.add(mensaje);

		}

		return encontrados;
	}

	@Override
	public String toString() {
		return "Sistema [listaMensajes=" + listaMensajes + "]\n";
	}

}
