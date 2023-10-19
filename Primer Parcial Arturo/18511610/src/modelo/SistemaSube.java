package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemaSube {
	private List<Usuario> usuarios;
	private List<Tarjeta> tarjetas;
	private List<Viaje> viajes;

	public SistemaSube() {
		super();
		usuarios = new ArrayList<>();
		tarjetas = new ArrayList<>();
		viajes = new ArrayList<>();
	}

	public boolean agregarTarjeta(String codigo, Usuario usuario) throws Exception {
		return getTarjetas().add(new Tarjeta(codigo, usuario));
	}

	public Tarjeta traerTarjeta(String codigo) {
		Tarjeta encontrada = null;
		int i = 0;
		while (encontrada == null && i < getTarjetas().size()) {
			if (getTarjetas().get(i).getCodigo().equals(codigo))
				encontrada = getTarjetas().get(i);
			i++;
		}
		return encontrada;
	}

	public boolean agregarUsuario(long dni, String nombre, String apellido, boolean tieneDescuento) throws Exception {
		Usuario userSube = traerUsuario(dni);
		if (userSube != null)
			throw new Exception("ya existe usuario con mismo DNI");
		return getUsuarios().add(new Usuario(proximoUserID(), dni, nombre, apellido, tieneDescuento));

	}

	public Usuario traerUsuario(long dni) {
		Usuario encontrado = null;
		int i = 0;
		while (encontrado == null && i < getUsuarios().size()) {
			if (getUsuarios().get(i).getDni() == dni)
				encontrado = getUsuarios().get(i);
			i++;
		}
		return encontrado;
	}

	private int proximoUserID() { // devuelve ID
		int prox = 1;
		if (!getUsuarios().isEmpty())
			prox = getUsuarios().get(getUsuarios().size() - 1).getId() + 1;

		return prox;
	}

	// ----------- GET / SET
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "SistemaSube [" + usuarios + tarjetas + viajes + "]";
	}

	public void agregarViaje(Tarjeta traerTarjeta, String linea, String medio, LocalDateTime fechaHoraViaje,
			double precio) {
		getViajes().add(new Viaje(traerTarjeta, linea, medio, fechaHoraViaje, precio));
	}

	public List<Viaje> traerViaje(LocalDateTime dde, LocalDateTime hta) {
		List<Viaje> viajesEntre = new ArrayList<>();
		for (Viaje viaje : getViajes()) {
			if ((viaje.getFechaHoraViaje().equals(dde) || viaje.getFechaHoraViaje().isAfter(dde))
					&& (viaje.getFechaHoraViaje().equals(hta) || viaje.getFechaHoraViaje().isBefore(hta)))
				viajesEntre.add(viaje);
		}
		return viajesEntre;
	}

	public double calcularTotalFacturadoEntreFechas(LocalDateTime dde, LocalDateTime hta) {
		double resultado = 0;

		List<Viaje> subtViajes = traerViaje(dde, hta);

		for (Viaje viaje : subtViajes) {
			resultado += viaje.totalAPagar();
		}

		return resultado;
	}

}
