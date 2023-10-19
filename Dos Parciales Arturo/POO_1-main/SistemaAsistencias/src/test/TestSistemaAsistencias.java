package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import modelo.Asistencia;
import modelo.Sistema;

public class TestSistemaAsistencias {

	public static void main(String[] args) {
		System.out.println("Test suite Sistema de Asistencias");

		// creamos la clase control sistema
		Sistema testSis = new Sistema();

		// UC - 1
		System.out.print("1-1 -  Crear y agregar a la lista el objeto TrabajoPresencial ? ");
		try {
			System.out.println(testSis.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "1578", LocalTime.of(9, 00),
					LocalTime.of(17, 00)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // id-1

		// UC - 2
		System.out.print("1-2 -  Crear y agregar a la lista el objeto Teletrabajo ? ");
		try {
			System.out.println(testSis.agregarTeletrabajo(LocalDate.of(2020, 10, 15), "3782", "Pandemia", 5));
		} catch (Exception e) {
			e.printStackTrace();
		} // id-2

		// UC - 3
		System.out.println("1-3 Intentar crear y agregar a la lista los siguientes objetos ? ");
		try {
			System.out.println("TrabajoPresencial: " + testSis.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15),
					"1578", LocalTime.of(10, 00), LocalTime.of(18, 00)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // id-3
		try {
			System.out.println(
					"Teletrabajo: " + testSis.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "3724", "Pandemia", 9));
		} catch (Exception e) {
			e.printStackTrace();
		} // id-4

		// UC - 3
		System.out.println("2-1 Traer e imprimir la cantidad de horas trabajadas de las asistencias con id 1 y 2 ");
		System.out.println(
				"Id 1 : " + testSis.traerAsistencia(LocalDate.of(2020, 10, 15), "1578").calcularHorasTrabajadas());
		System.out.println(
				"Id 2 : " + testSis.traerAsistencia(LocalDate.of(2020, 10, 15), "3782").calcularHorasTrabajadas());

		// probar el ejemplo de la guia
		try {
			System.out.println(testSis.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15), "1579",
					LocalTime.of(12, 05), LocalTime.of(13, 35)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // id-nn

		System.out.println(
				"Id nn : " + testSis.traerAsistencia(LocalDate.of(2020, 10, 15), "1579").calcularHorasTrabajadas());

		// UC - 4
		System.out.println("3 Agregar los siguientes objetos a la lista");
		try {
			System.out.println("TrabajoPresencial: " + testSis.agregarTrabajoPresencial(LocalDate.of(2020, 10, 15),
					"2839", LocalTime.of(9, 00), LocalTime.of(17, 00)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // id-5
		try {
			System.out.println(
					"Teletrabajo: " + testSis.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "3452", "Pandemia", 5));
		} catch (Exception e) {
			e.printStackTrace();
		} // id-6
		try {
			System.out.println(
					"Teletrabajo: " + testSis.agregarTeletrabajo(LocalDate.of(2020, 10, 16), "5243", "Pandemia", 7));
		} catch (Exception e) {
			e.printStackTrace();
		} // id-7

		// UC - 5
		System.out.println("4-1) Traer todas las asistencias del 15/10/2020");
		List<Asistencia> encontradas = testSis.traerAsistencia(LocalDate.of(2020, 10, 15));
		System.out.println(encontradas);

		// UC - 6
		System.out.println("4-2 Traer todas las asistencias de Teletrabajo");
		boolean esPresencial = true; // se crea la variable auxiliar para que se entienda mejor
		encontradas = testSis.traerAsistencia(esPresencial);
		System.out.println(encontradas);

	}

}
