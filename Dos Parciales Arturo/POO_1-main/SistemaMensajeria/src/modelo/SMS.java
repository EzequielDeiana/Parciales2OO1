package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class SMS extends Mensaje {
	private int numeroOrigen;
	private int numeroDestino;
	private String texto;
	private boolean visto;
	private OperadorMovil operadorOrigen;
	private OperadorMovil operadorDestino;

	public SMS(LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino, String texto,
			OperadorMovil operadorOrigen, OperadorMovil operadorDestino) throws Exception {
		super(fechaEnvio, horaEnvio);
		this.numeroOrigen = numeroOrigen;
		setNumeroDestino(numeroDestino);
		this.texto = texto;
		this.visto = false;
		this.operadorOrigen = operadorOrigen;
		this.operadorDestino = operadorDestino;
	}

	public int getNumeroDestino() {
		return numeroDestino;
	}

	public void setNumeroDestino(int numeroDestino) throws Exception {
		if (String.valueOf(numeroDestino).length() != 10)
			throw new Exception("cantidad de digitos distinto a 10");
		this.numeroDestino = numeroDestino;
	}

	@Override
	public void cambiardeEstado(boolean estadoNuevo) {
		this.visto = estadoNuevo;

	}

	@Override
	public String toString() {
		return "SMS [numeroOrigen=" + numeroOrigen + ", numeroDestino=" + numeroDestino + ", texto=" + texto
				+ ", visto=" + visto + ", operadorOrigen=" + operadorOrigen + ", operadorDestino=" + operadorDestino
				+ super.toString() + "]\n";
	}

	public OperadorMovil getOperadorOrigen() {
		return operadorOrigen;
	}

	public void setOperadorOrigen(OperadorMovil operadorOrigen) {
		this.operadorOrigen = operadorOrigen;
	}

}
