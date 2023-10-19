package modelo;

public abstract class Cliente {
	protected int id;
	protected long numeroCliente;
	
	
	protected Cliente(long numeroCliente) {
		super();
		this.numeroCliente = numeroCliente;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getNumeroCliente() {
		return numeroCliente;
	}
	public void setNumeroCliente(long numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public boolean equals(Cliente cliente) {
		boolean resultado = false;
		
		if(getNumeroCliente() == cliente.getNumeroCliente()) {
			resultado = true;
		}
		
		return resultado;
	}

	
	
}
