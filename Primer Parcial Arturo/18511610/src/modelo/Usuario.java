package modelo;

public class Usuario {
	private int id;
	private long dni;
	private String nombre;
	private String apellido;
	private boolean tieneDescuento;

	public Usuario(int id, long dni, String nombre, String apellido, boolean tieneDescuento) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tieneDescuento = tieneDescuento;

	}

// ----------- GET / SET
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
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

	public boolean isTieneDescuento() {
		return tieneDescuento;
	}

	public void setTieneDescuento(boolean tieneDescuento) {
		this.tieneDescuento = tieneDescuento;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", tieneDescuento=" + tieneDescuento + "]\n";
	}

}
