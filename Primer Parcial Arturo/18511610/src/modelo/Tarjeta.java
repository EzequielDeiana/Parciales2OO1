package modelo;

public class Tarjeta {
	private String codigo;
	private Usuario usuario;

	public Tarjeta(String codigo, Usuario usuario) throws Exception {
		super();
		setCodigo(codigo);
		this.usuario = usuario;
	}

	// ----------- GET / SET
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {
		if (codigo.length() < 10)
			throw new Exception("nro tarjeta Incorrecto");
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Tarjeta [codigo=" + codigo + ", usuario=" + usuario + "]";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
