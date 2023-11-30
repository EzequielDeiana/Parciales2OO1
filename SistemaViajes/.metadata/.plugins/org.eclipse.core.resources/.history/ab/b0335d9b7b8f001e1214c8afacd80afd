package test;

import java.time.LocalDateTime;

import modelo.SistemaViajes;

public class testOO1 {

	public static void main(String[] args) {
		SistemaViajes s1 = new SistemaViajes();

		System.out.println("Test 1.");
		
		try {
			s1.agregarTarjetaEstudiantil("11111111", 1000.0, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarTarjetaJubilacion("22222222", 40.0, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarTarjetaJubilacion("33333333", 50.0, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarTarjetaEstudiantil("44444444", 80.0, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarTarjetaJubilacion("55555555", 40.0, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarTarjetaJubilacion("66666666", 60.0, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s1.getTarjetas());
		
		System.out.println("Test 2.");
		try {
			s1.agregarTarjetaEstudiantil("11111111", 1000.0, true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test 3.");
		
		try {
			s1.agregarViaje(s1.traerTarjeta("11111111"), "linea 1", "medio 1" ,LocalDateTime.of(2023, 9, 1, 10, 0), 50.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarViaje(s1.traerTarjeta("11111111"), "linea 2", "medio 2" ,LocalDateTime.of(2023, 9, 1, 10, 30), 50.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarViaje(s1.traerTarjeta("22222222"), "linea 1", "medio 1" ,LocalDateTime.of(2023, 9, 1, 10, 0), 60.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarViaje(s1.traerTarjeta("22222222"), "linea 3", "medio 3" ,LocalDateTime.of(2023, 9, 2, 11, 0), 100.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarViaje(s1.traerTarjeta("33333333"), "linea 2", "medio 2" ,LocalDateTime.of(2023, 9, 2, 15, 0), 60.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarViaje(s1.traerTarjeta("33333333"), "linea 3", "medio 3" ,LocalDateTime.of(2023, 9, 3, 22, 0), 60.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarViaje(s1.traerTarjeta("44444444"), "linea 2", "medio 2" ,LocalDateTime.of(2023, 9, 2, 10, 30), 100.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarViaje(s1.traerTarjeta("44444444"), "linea 3", "medio 3" ,LocalDateTime.of(2023, 9, 3, 10, 00), 100.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s1.getViajes());
		
		System.out.println("Test 4.");
		try {
			s1.agregarViaje(s1.traerTarjeta("11111111"), "linea 1", "medio 1" ,LocalDateTime.of(2023, 9, 1, 10, 0), -10.0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test 5.");
		System.out.println(s1.traerViaje(LocalDateTime.of(2023, 9, 2, 10, 30), LocalDateTime.of(2023, 9, 3, 10, 0)));
		
		System.out.println("Test 6.");
		System.out.println(s1.traerViajeTarjetaEstudiantil(LocalDateTime.of(2023, 9, 2, 10, 30), LocalDateTime.of(2023, 9, 3, 10, 0)));
		
		System.out.println("Test 7.");
		System.out.println(s1.calcularTotalFacturadoEntreFechas(LocalDateTime.of(2023, 9, 2, 10, 30), LocalDateTime.of(2023, 9, 3, 10, 0)));
		
		System.out.println("Test 8.");
		System.out.println(s1.traerTarjetaJubilacionActivaConPorcentajeMayorA(50));
	}

}
