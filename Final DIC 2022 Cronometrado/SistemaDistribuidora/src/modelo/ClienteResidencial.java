package modelo;

public class ClienteResidencial extends Cliente{
	
	private String nombre;
	private String apellido;
	private int dni;
	private int kWhSubsidio;
	
	public ClienteResidencial(int id, long numeroCliente, String nombre,  String apellido, int dni, int kWhSubsidio) {
		super(id, numeroCliente);
		this.id = id;
		this.numeroCliente = numeroCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.kWhSubsidio = kWhSubsidio;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getkWhSubsidio() {
		return kWhSubsidio;
	}

	public void setkWhSubsidio(int kWhSubsidio) {
		this.kWhSubsidio = kWhSubsidio;
	}

	@Override
	public String toString() {
		return "ClienteResidencial [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", kWhSubsidio="
				+ kWhSubsidio + ", id=" + id + ", numeroCliente=" + numeroCliente + "]";
	}

	
	
	
}
