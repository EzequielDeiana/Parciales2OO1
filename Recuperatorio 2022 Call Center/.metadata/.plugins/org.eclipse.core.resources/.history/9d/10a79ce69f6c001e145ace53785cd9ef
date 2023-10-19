package modulo;

import java.time.LocalDate;

public class Cliente extends Persona{
	private boolean activo;
	
	protected Cliente(int idPersona, String nombre, String apellido, long dni, LocalDate fechaDeAlta, boolean activo) {
		super(idPersona, nombre, apellido, dni, fechaDeAlta);
		this.activo = activo;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	protected int antiguedadEnAnios() {
		int antiguedad = 0;
		
		if(activo) {
			antiguedad = LocalDate.now().getYear() - fechaDeAlta.getYear();
		}
		
		return antiguedad;
	}

	@Override
	public String toString() {
		return "Cliente [activo=" + activo + ", idPersona=" + idPersona + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + ", fechaDeAlta=" + fechaDeAlta + "]";
	}
	
	
	
}
