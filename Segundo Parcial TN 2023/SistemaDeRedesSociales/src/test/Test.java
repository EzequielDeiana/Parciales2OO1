package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Sistema;

public class Test {

	public static void main(String[] args) {
		Sistema s1 = new Sistema();
		
		System.out.println("1)");
		
		try {
			s1.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarUsuario("usuarioCreador2", LocalDate.of(2023, 9, 2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarUsuario("usuarioCreador3", LocalDate.of(2023, 9, 3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarUsuario("usuarioCreador4", LocalDate.of(2023, 9, 4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarUsuario("usuarioCreador5", LocalDate.of(2023, 9, 5));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarUsuario("usuarioLector1", LocalDate.of(2023, 9, 6));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarUsuario("usuarioLector2", LocalDate.of(2023, 9, 7));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarUsuario("usuarioLector3", LocalDate.of(2023, 9, 8));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s1.getLstUsuarios());
		
		System.out.println("2)");
		
		try {
			s1.agregarPosteo(LocalDate.of(2023, 10, 1), LocalTime.of(10, 0), s1.traerUsuario("usuarioCreador1"), "Que dia es el segundo parcial de OO1?", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarPosteo(LocalDate.of(2023, 10, 5), LocalTime.of(11, 0), s1.traerUsuario("usuarioCreador2"), "Comenten de que pais me estan leyendo", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarPosteo(LocalDate.of(2023, 10, 10), LocalTime.of(12, 0), s1.traerUsuario("usuarioCreador3"), "Hoy nos reunimos en mi casa!", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			s1.agregarAvisoGeneral(LocalDate.of(2023, 10, 15), LocalTime.of(13, 0), s1.traerUsuario("usuarioCreador4"), "Alerta para vecinos de Lanús", "Anuncian fuertes lluvias para las 18Hs");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarAvisoGeneral(LocalDate.of(2023, 10, 20), LocalTime.of(14, 0), s1.traerUsuario("usuarioCreador5"), "Información Importante" ,"La facultad permanecerá abierta hasta las 20Hs");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s1.getLstPublicaciones());
		
		System.out.println("3)");
		
		s1.agregarComentario(111, s1.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 0)), s1.traerUsuario("usuarioLector2"), "Uruguay");
		s1.agregarComentario(222, s1.traerPublicacion("usuarioCreador2", LocalDate.of(2023, 10, 5), LocalTime.of(11, 0)), s1.traerUsuario("usuarioLector3"), "Chile");
		s1.agregarComentario(333, s1.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 1), LocalTime.of(10, 0)), s1.traerUsuario("usuarioLector1"), "No recuerdo");
		s1.agregarComentario(444, s1.traerPublicacion("usuarioCreador1", LocalDate.of(2023, 10, 1), LocalTime.of(10, 0)), s1.traerUsuario("usuarioLector2"), "Es el Martes 17/10/2023");
		
		System.out.println(s1.getLstComentarios());
		
		System.out.println("4)");
		
		System.out.println(s1.traerPublicacionPublicas(LocalDate.of(2023, 10, 5), LocalDate.of(2023, 10, 17)));
		
		System.out.println("5)");
		
		System.out.println(s1.traerComentariosEnPosteosPorUsuario(s1.traerUsuario("usuarioLector2")));
		
		System.out.println("6)");
		
		System.out.println(s1.traerPublicacionesQueContentanTexto("de"));
		
		
		System.out.println("7)");
		
		try {
			s1.agregarUsuario("usuarioCreador1", LocalDate.of(2023, 9, 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("8)");
		
		try {
			s1.agregarPosteo(LocalDate.of(2023, 10, 1), LocalTime.of(10, 0), s1.traerUsuario("usuarioCreador1"), "Que dia es el segundo parcial de OO1?", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}