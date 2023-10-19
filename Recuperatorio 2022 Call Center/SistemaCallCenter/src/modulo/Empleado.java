package modulo;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona {
	private int sueldoBase;

	protected Empleado(int idPersona, String nombre, String apellido, long dni, LocalDate fechaDeAlta, int sueldoBase) {
		super(idPersona, nombre, apellido, dni, fechaDeAlta);
		this.sueldoBase = sueldoBase;
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(int sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	@Override
	protected int antiguedadEnAnios() {
		int antiguedad = (Period.between(fechaDeAlta, LocalDate.now().plusMonths(1).withDayOfMonth(1))).getYears();
		
		if(LocalDate.now().plusMonths(1).withDayOfMonth(1).getDayOfWeek().getValue() > 5) {
			antiguedad = (Period.between(fechaDeAlta, LocalDate.now().plusMonths(1).withDayOfMonth(2))).getYears();
			if(LocalDate.now().plusMonths(1).withDayOfMonth(1).getDayOfWeek().getValue() > 6) {
				antiguedad = (Period.between(fechaDeAlta, LocalDate.now().plusMonths(1).withDayOfMonth(3))).getYears();
			}
		}
		
		return antiguedad;
	}

	@Override
	public String toString() {
		return "Empleado [sueldoBase=" + sueldoBase + ", idPersona=" + idPersona + ", nombre=" + nombre + ", apellido="
				+ apellido + ", dni=" + dni + ", fechaDeAlta=" + fechaDeAlta + "]";
	}
	
	

}
