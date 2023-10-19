package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Posteo extends Publicacion{
	private String texto;
	private boolean publico;
	
	protected Posteo(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String texto, boolean publico) {
		super(idPublicacion, fecha, hora, creador);
		this.texto = texto;
		this.publico = publico;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	@Override
	public boolean contieneTexto(String buscar) {
		boolean encontrado = false;
		if(texto.indexOf(buscar) != -1) {
			encontrado = true;
		}
		return encontrado;
	}

	@Override
	public String toString() {
		return "Posteo [texto=" + texto + ", publico=" + publico + ", idPublicacion=" + idPublicacion + ", fecha="
				+ fecha + ", hora=" + hora + ", creador=" + creador + "]";
	}

	
	
}
