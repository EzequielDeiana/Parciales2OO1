package modelo;

public class ClienteCorporativo extends Cliente{
	
	private long cuit;
	private String razonSocial;

	protected ClienteCorporativo(long numeroCliente, long cuit, String razonSocial) {
		super(numeroCliente);
		this.cuit = cuit;
		this.razonSocial = razonSocial;
	}

	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return "ClienteCorporativo [cuit=" + cuit + ", razonSocial=" + razonSocial + ", id=" + id + ", numeroCliente="
				+ numeroCliente + "]";
	}

	
	
}
