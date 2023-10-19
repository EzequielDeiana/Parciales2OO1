package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Llamada {
	private int idLlamada;
	private LocalDate fecha;
	private LocalTime hora;
	private Cliente cliente;
	private Empleado empleado;
	private int nivelSatisfaccion;

	public Llamada(int idLlamada, LocalDate fecha, LocalTime hora, Cliente cliente, Empleado empleado,
			int nivelSatisfaccion) throws Exception {
		super();
		this.idLlamada = idLlamada;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.empleado = empleado;
		setNivelSatisfaccion(nivelSatisfaccion);
	}
	
	public boolean esNivelDeSatisfaccionValido(int nivelDeSatisfaccion) {
		if(nivelDeSatisfaccion > 0 && nivelDeSatisfaccion < 6) {
			return true;
		}
		return false;
	}
	
	public int getIdLlamada() {
		return idLlamada;
	}

	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public int getNivelSatisfaccion() throws Exception{
		return nivelSatisfaccion;
	}

	public void setNivelSatisfaccion(int nivelSatisfaccion) throws Exception{
		if(esNivelDeSatisfaccionValido(nivelSatisfaccion)) {
			this.nivelSatisfaccion = nivelSatisfaccion;
		} else {
			throw new Exception("Nivel de Satisfaccion invalido");
		}
		
	}

	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", fecha=" + fecha + ", hora=" + hora + ", cliente=" + cliente
				+ ", empleado=" + empleado + ", nivelSatisfaccion=" + nivelSatisfaccion + "]";
	}
	
	

}
