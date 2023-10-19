package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

import modelo.SistemaSube;
import modelo.Viaje;

public class Test {

	public static void main(String[] args) {
		System.out.println("Parcial de Orientacion a Objetos 1\n");
		System.out.println("Alumno: Eduartes Arturo - DNI 18511610");
		System.out.println("Suite Test Sistema Sube");

		// sistema sube a testear
		SistemaSube s1 = new SistemaSube();

		// -------------
		System.out.println("Test 1 - agregar usuarios e imprimir lista");
		try {
			s1.agregarUsuario(11111111, "nombre 1", "apellido 1", false); // id 1
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			s1.agregarUsuario(22222222, "nombre 2", "apellido 2", false); // id 2
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			s1.agregarUsuario(33333333, "nombre 3", "apellido 3", true); // id 3
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\n" + s1 + "\n");

		// -------------
		System.out.println("\nTest 2 - agregar nuevamente usuario con DNI 22222222");

		try {
			s1.agregarUsuario(22222222, "nombre 2", "apellido 2", false); // id 2
		} catch (Exception e) {
			e.printStackTrace();
		}

		// -------------
		System.out.println("\nTest 3 - agregar tarjetas al sistema e imprimir lista");
		try {
			s1.agregarTarjeta("1234567890", s1.traerUsuario(11111111)); // id 1
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			s1.agregarTarjeta("1234567891", s1.traerUsuario(22222222)); // id 2
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			s1.agregarTarjeta("1234567892", s1.traerUsuario(33333333)); // id 3
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\n" + s1 + "\n");

		// -------------
		System.out.println("\nTest 3 - agregar tarjetas con codigo 1234");
		try {
			s1.agregarTarjeta("1234", s1.traerUsuario(22222222));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// -------------
		System.out.println("\nTest 4 - agregar viajes e imprimir");
		s1.agregarViaje(s1.traerTarjeta("1234567890"), "linea 1", "medio1",
				LocalDateTime.of(LocalDate.of(2023, 9, 01), LocalTime.of(10, 00)), 50.0); // id 1
		s1.agregarViaje(s1.traerTarjeta("1234567890"), "linea 2", "medio2",
				LocalDateTime.of(LocalDate.of(2023, 9, 01), LocalTime.of(10, 30)), 50.0); // id 2
		s1.agregarViaje(s1.traerTarjeta("1234567890"), "linea 3", "medio3",
				LocalDateTime.of(LocalDate.of(2023, 9, 02), LocalTime.of(9, 00)), 100.0); // id 3

		s1.agregarViaje(s1.traerTarjeta("1234567891"), "linea 1", "medio1",
				LocalDateTime.of(LocalDate.of(2023, 9, 01), LocalTime.of(10, 00)), 60.0); // id 4
		s1.agregarViaje(s1.traerTarjeta("1234567891"), "linea 2", "medio2",
				LocalDateTime.of(LocalDate.of(2023, 9, 02), LocalTime.of(15, 00)), 60.0); // id 5
		s1.agregarViaje(s1.traerTarjeta("1234567891"), "linea 3", "medio3",
				LocalDateTime.of(LocalDate.of(2023, 9, 03), LocalTime.of(22, 00)), 60.0); // id 6

		s1.agregarViaje(s1.traerTarjeta("1234567892"), "linea 1", "medio1",
				LocalDateTime.of(LocalDate.of(2023, 9, 01), LocalTime.of(10, 00)), 100.0); // id 7
		s1.agregarViaje(s1.traerTarjeta("1234567892"), "linea 2", "medio2",
				LocalDateTime.of(LocalDate.of(2023, 9, 02), LocalTime.of(10, 30)), 100.0); // id 8
		s1.agregarViaje(s1.traerTarjeta("1234567892"), "linea 3", "medio3",
				LocalDateTime.of(LocalDate.of(2023, 9, 03), LocalTime.of(10, 00)), 100.0); // id 9

		System.out.println("\n" + s1 + "\n");

		// -------------
		System.out.println(
				"\nTest 5 - traer e imprimir viajes entre fechas 2023-09-02 -10:30 y 2023-09-03-10:00 (inclusive)");
		List<Viaje> viajesEncontrados = s1.traerViaje(
				LocalDateTime.of(LocalDate.of(2023, Month.SEPTEMBER, 02), LocalTime.of(10, 30)),
				LocalDateTime.of(LocalDate.of(2023, Month.SEPTEMBER, 03), LocalTime.of(10, 00)));

		System.out.println(viajesEncontrados);

		// -------------
		System.out.println(
				"\nTest 5 - calcular e imprimir facturas entre fechas 2023-09-02 -10:30 y 2023-09-03-10:00 (inclusive)");
		double resultado = s1.calcularTotalFacturadoEntreFechas(
				LocalDateTime.of(LocalDate.of(2023, Month.SEPTEMBER, 02), LocalTime.of(10, 30)),
				LocalDateTime.of(LocalDate.of(2023, Month.SEPTEMBER, 03), LocalTime.of(10, 00)));

		System.out.println("total Facturado entre fechas " + resultado);
	}

}
