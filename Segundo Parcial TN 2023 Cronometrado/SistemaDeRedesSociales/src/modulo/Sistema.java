package modulo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private List<Usuario> lstUsuarios;
	private List<Publicacion> lstPublicaciones;
	private List<Comentario> lstComentarios;
	public Sistema() {
		super();
		this.lstUsuarios = new ArrayList<Usuario>();
		this.lstPublicaciones = new ArrayList<Publicacion>();
		this.lstComentarios = new ArrayList<Comentario>();
	}
	
	public boolean agregarUsuario(String nombreUsuario, LocalDate fechaAlta) throws Exception{
		Usuario aux = traerUsuario(nombreUsuario);
		if(aux != null) {
			throw new Exception("Ya existe un usuario con este Nombre de Usuario");
		}
		return getLstUsuarios().add(new Usuario(getProximoIDUsuario(), nombreUsuario, fechaAlta));
	}
	
	public Usuario traerUsuario(String nombreUsuario) {
		int i = 0;
		boolean encontrado = false;
		Usuario aux = null;
		
		while(i < getLstUsuarios().size() && encontrado == false) {
			
			if(getLstUsuarios().get(i).getNombreUsuario().equals(nombreUsuario)) {
				aux = getLstUsuarios().get(i);
				encontrado = true;
			}
			
			i++;
		}
		
		return aux;
	}
	
	private int getProximoIDUsuario() {
		int id = 1;
		
		if(!getLstUsuarios().isEmpty()) {
			id = getLstUsuarios().get(getLstUsuarios().size()-1).getIdUsuario()+1;
		}
		
		return id;
	}
	
	//Metodos de Publicacion
	
	public boolean agregarPosteo(LocalDate fecha, LocalTime hora, Usuario creador ,String texto, boolean publico) throws Exception{
		Publicacion aux = traerPublicacion(creador.getNombreUsuario(), fecha, hora);
		if(aux != null) {
			throw new Exception("Ya existe una publicacion con el mismo creador, fecha y hora");
		}
		
		return getLstPublicaciones().add(new Posteo(getProximoIDPublicacion(), fecha, hora, creador, texto, publico));
	}
	
	public boolean agregarAvisoGeneral(LocalDate fecha, LocalTime hora, Usuario creador, String titulo, String cuerpo) throws Exception {
		Publicacion aux = traerPublicacion(creador.getNombreUsuario(), fecha, hora);
		if(aux != null) {
			throw new Exception("Ya existe una publicacion con el mismo creador, fecha y hora");
		}
		
		return getLstPublicaciones().add(new AvisoGeneral(getProximoIDPublicacion(), fecha, hora, creador, titulo, cuerpo));
	}
	
	public Publicacion traerPublicacion(String nombreUsuario, LocalDate fecha, LocalTime hora) {
		int i = 0;
		boolean encontrado = false;
		Publicacion aux = null;
		
		while(i < getLstPublicaciones().size() && encontrado == false) {
			if(getLstPublicaciones().get(i).getCreador().getNombreUsuario().equals(nombreUsuario) &&
					getLstPublicaciones().get(i).getFecha().isEqual(fecha) &&
					getLstPublicaciones().get(i).getHora().equals(hora)){
						aux = getLstPublicaciones().get(i);
						encontrado = true;
					}
			i++;
		}
		
		return aux;
	}
	
	private int getProximoIDPublicacion() {
		int id = 1;
		
		if(!getLstPublicaciones().isEmpty()) {
			id = getLstPublicaciones().get(getLstPublicaciones().size()-1).getIdPublicacion()+1;
		}
		
		return id;
	}
	
	public List<Publicacion> traerPublicacionesPublicas(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Publicacion> lstAux = new ArrayList<Publicacion>();
		
		for (Publicacion publicacion : getLstPublicaciones()) {
			if((publicacion.getFecha().isEqual(fechaDesde) || publicacion.getFecha().isAfter(fechaDesde)) &&
			(publicacion.getFecha().isBefore(fechaHasta) || publicacion.getFecha().isEqual(fechaHasta))) {
				if(publicacion instanceof Posteo) {
					Posteo posteoAux = (Posteo) publicacion;
					if(posteoAux.isPublico() == true) {
						lstAux.add(publicacion);
					}
				} else {
					lstAux.add(publicacion);
				}
			}
		}
		
		return lstAux;
	}
	
	public List<Publicacion> traerPublicacionesQueContenganTexto(String texto){
		List<Publicacion> lstAux = new ArrayList<Publicacion>();
		
		for (Publicacion publicacion : getLstPublicaciones()) {
			if(publicacion.contieneTexto(texto)) {
				lstAux.add(publicacion);
			}
		}
		
		
		return lstAux;
	}
	
	//Metodos de Comentario
	
	public boolean agregarComentario(Integer identificacion, Publicacion publicacion, Usuario usuario, String texto) {
		return getLstComentarios().add(new Comentario(getProximoIDComentario(), identificacion, publicacion, usuario, texto));
	}
	
	private int getProximoIDComentario() {
		int id = 1;
		
		if(!getLstComentarios().isEmpty()) {
			id = getLstComentarios().get(getLstComentarios().size()-1).getIdComentario()+1;
		}
		
		return id;
	}
	
	public List<Comentario> traerComentariosEnPosteosPorUsuario(Usuario usuario){
		List<Comentario> lstAux = new ArrayList<Comentario>();
		
		for (Comentario comentario : getLstComentarios()) {
			if(comentario.getUsuario().getNombreUsuario().equals(usuario.getNombreUsuario())) {
				Publicacion publicacionAux = comentario.getPublicacion();
				if(publicacionAux instanceof Posteo) {
					lstAux.add(comentario);
				}
			}
		}
		
		return lstAux;
	}
	
	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}
	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}
	public List<Publicacion> getLstPublicaciones() {
		return lstPublicaciones;
	}
	public void setLstPublicaciones(List<Publicacion> lstPublicaciones) {
		this.lstPublicaciones = lstPublicaciones;
	}
	public List<Comentario> getLstComentarios() {
		return lstComentarios;
	}
	public void setLstComentarios(List<Comentario> lstComentarios) {
		this.lstComentarios = lstComentarios;
	}
	
	
	
}
