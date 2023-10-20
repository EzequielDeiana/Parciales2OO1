package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public class AvisoGeneral extends Publicacion{
	
	private String titulo;
	private String cuerpo;
	
	public AvisoGeneral(int idPublicacion, LocalDate fecha, LocalTime hora, Usuario creador, String titulo, String cuerpo) {
		super(idPublicacion, fecha, hora, creador);
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	@Override
	public boolean contieneTexto(String buscar) {
		boolean encontrado = false;
		
		if(getTitulo().indexOf(buscar) > -1) {
			encontrado = true;
		}
		if(getCuerpo().indexOf(buscar) > -1) {
			encontrado = true;
		}
		
		return encontrado;
	}

	@Override
	public String toString() {
		return "AvisoGeneral [titulo=" + titulo + ", cuerpo=" + cuerpo + ", idPublicacion=" + idPublicacion + ", fecha="
				+ fecha + ", hora=" + hora + ", creador=" + creador + "]";
	}

	
	
}
