package modulo;

public class Comentario {
	private int idComentario;
	private int identificacion;
	private Publicacion publicacion;
	private Usuario usuario;
	private String texto;
	
	
	
	public Comentario(int idComentario, int identificacion, Publicacion publicacion, Usuario usuario, String texto) {
		super();
		this.idComentario = idComentario;
		this.identificacion = identificacion;
		this.publicacion = publicacion;
		this.usuario = usuario;
		this.texto = texto;
	}
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public Publicacion getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", identificacion=" + identificacion + ", publicacion="
				+ publicacion + ", usuario=" + usuario + ", texto=" + texto + "]";
	}
	
	
	
}
