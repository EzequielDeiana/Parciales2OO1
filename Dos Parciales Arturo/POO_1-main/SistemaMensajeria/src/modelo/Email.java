package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Email extends Mensaje {
	private String origen;
	private String destino;
	private String asunto;
	private String cuerpo;
	private boolean recibido;

	public Email(LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino, String asunto, String cuerpo)
			throws Exception {
		super(fechaEnvio, horaEnvio);
		this.origen = origen;
		setDestino(destino);
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.recibido = false;
	}

	@Override
	public void cambiardeEstado(boolean estadoNuevo) {
		this.recibido = estadoNuevo;

	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) throws Exception {

		if (destino.indexOf("@") == -1)
			throw new Exception("falta el caracter @");
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "Email [origen=" + origen + ", destino=" + destino + ", asunto=" + asunto + ", cuerpo=" + cuerpo
				+ ", recibido=" + recibido + super.toString() + "]\n";
	}

}
