package modelo;

import java.time.LocalDate;

public class Lectura {

		private int id;
		private LocalDate fecha;
		private Cliente cliente;
		private int estadoMedidor;
		
		
		
		public Lectura(int id, LocalDate fecha, Cliente cliente, int estadoMedidor) {
			super();
			this.id = id;
			this.fecha = fecha;
			this.cliente = cliente;
			this.estadoMedidor = estadoMedidor;
		}
		
		public int calcularConsumo(Lectura lecturaAnterior) {
			int lectura = getEstadoMedidor() - lecturaAnterior.getEstadoMedidor();
			return lectura;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public LocalDate getFecha() {
			return fecha;
		}
		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
		public Cliente getCliente() {
			return cliente;
		}
		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}
		public int getEstadoMedidor() {
			return estadoMedidor;
		}
		public void setEstadoMedidor(int estadoMedidor) {
			this.estadoMedidor = estadoMedidor;
		}

		@Override
		public String toString() {
			return "Lectura [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", estadoMedidor="
					+ estadoMedidor + "]";
		}
		
		
		
	
}
