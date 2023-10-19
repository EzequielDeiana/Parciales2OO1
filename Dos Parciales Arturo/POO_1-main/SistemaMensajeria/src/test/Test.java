/*
 * Capa test:
 * 
 * Nota​:​ Al comenzar cada test indicar el número a resolver ej: System.out.println("1-3)”);
 * y luego la implementación del mismo.
Test.java


4-3) Traer e imprimir los mensajes que se hayan enviado el día 15/12/2020 entre las 12 y las 13Hs y
que tengan como compañía origen “Movistar”

*/

package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import modelo.Email;
import modelo.Mensaje;
import modelo.OperadorMovil;
import modelo.SMS;
import modelo.Sistema;

public class Test {

	public static void main(String[] args) {

		Sistema sms = new Sistema();

		System.out.println("Test Suite para sistema de Mensajeria");

		// UC1_1 --------------------------------------
		System.out.println("1-1) Intentar agregar a la lista el objeto SMS");
		try {
			System.out.println(sms.agregarSMS(LocalDate.of(2020, 12, 11), LocalTime.of(17, 37), 1523456780, 156543210,
					"Voy a llegar mas tarde", new OperadorMovil(1, "Personal"), new OperadorMovil(2, "Claro")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// UC1_2 --------------------------------------
		System.out.println("1-2) Agregar a la lista e imprimir el objeto SMS"); // id 1
		try {
			System.out.println(sms.agregarSMS(LocalDate.of(2020, 12, 11), LocalTime.of(17, 37), 1523456780, 1565432109,
					"Voy a llegar mas tarde", new OperadorMovil(1, "Personal"), new OperadorMovil(2, "Claro")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// UC1_3 --------------------------------------
		System.out.println("1-3) Intentar agregar a la lista el objeto Email");
		try {
			System.out.println(sms.agregarEmail(LocalDate.of(2020, 12, 13), LocalTime.of(15, 16),
					"informacion@unla.gob.ar", "alumno.com", "Informacion - UNLa",
					"Estimado alumno, le enviamos el protocolo para rendir el examen final virtual"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// UC1_4 --------------------------------------
		System.out.println("1-4) Agregar a la lista e imprimir el objeto Email:"); // id 2
		try {
			System.out.println(sms.agregarEmail(LocalDate.of(2020, 12, 13), LocalTime.of(15, 16),
					"informacion@unla.gob.ar", "alumno@gmail.com", "Informacion - UNLa",
					"Estimado alumno, le enviamos el protocolo para rendir el examen final virtual"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(sms.traerMensaje(2));

		// UC2_1 --------------------------------------
		System.out.println("\n 2-1) Traer e imprimir el SMS con IdMensaje = 1 y cambiar el estado a Visto=true:");
		Mensaje encontrado = sms.traerMensaje(1);
		if (encontrado != null && encontrado instanceof SMS)
			((SMS) encontrado).cambiardeEstado(true);

		System.out.println(sms.traerMensaje(1));

		// UC2_2 --------------------------------------
		System.out.println("\n 2-2) Traer e imprimir el Email con IdMensaje = 2 y cambiar el estado a Recibido=true");
		encontrado = sms.traerMensaje(2);
		if (encontrado != null && encontrado instanceof Email)
			((Email) encontrado).cambiardeEstado(true);

		System.out.println(sms.traerMensaje(2));

		// UC3 --------------------------------------
		System.out.println("3) Agregar los siguientes objetos a la lista, al finalizar la carga, imprimirla:");
		try {
			System.out.println(sms.agregarSMS(LocalDate.of(2020, 11, 15), LocalTime.of(12, 03), 1523456780, 1598760883,
					"Recibido OK", new OperadorMovil(3, "Movistar"), new OperadorMovil(2, "Claro")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println(sms.agregarSMS(LocalDate.of(2020, 12, 10), LocalTime.of(13, 16), 1523456780, 1598768250,
					"Gracias", new OperadorMovil(1, "Personal"), new OperadorMovil(3, "Movistar")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println(sms.agregarEmail(LocalDate.of(2020, 11, 8), LocalTime.of(17, 15), "oo1@unla.gob.ar",
					"alumno@gmail.com", "Orientacion a Objetos 1 - UNLa",
					"Se adjunta la grilla de inscripciones al final de Diciembre"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			System.out.println(sms.agregarEmail(LocalDate.of(2020, 12, 10), LocalTime.of(8, 19),
					"informacion@gmail.com.ar", "cliente@gmail.com", "Ofertas", "Aproveche nuestras ofertas"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(sms);

		// UC4_1 --------------------------------------
		System.out.println("4-1) Traer e imprimir los mensajes que tengan como operadorOrigen la compañía Personal:");

		List<Mensaje> encontrados = sms.traerMensaje("Personal");

		System.out.println(encontrados);

		// UC4_2 --------------------------------------
		System.out.println(
				"4-2) Traer e imprimir los mensajes que se hayan enviado el día 10/12/2020 entre las 8 y las 14Hs:");
		encontrados = sms.traerMensaje(LocalDate.of(2020, 12, 10), LocalTime.of(8, 0), LocalTime.of(14, 0));

		System.out.println(encontrados);

		// UC4_3 --------------------------------------
		System.out.println(
				" 4-3) Traer e imprimir los mensajes que se hayan enviado el día 15/12/2020 entre las 12 y las 13Hs y "
						+ "que tengan como compañía origen “Movistar”:");
		encontrados = sms.traerMensaje(LocalDate.of(2020, 12, 15), LocalTime.of(12, 0), LocalTime.of(13, 0),
				"Movistar");
		System.out.println(encontrados);

		System.err.println(
				"Se corrigio el ejercicio para traer datos de fecha 2020-11-15 para que muestre si recupera resultados");
		encontrados = sms.traerMensaje(LocalDate.of(2020, 11, 15), LocalTime.of(12, 0), LocalTime.of(13, 0),
				"Movistar");
		System.out.println(encontrados);

	}
}
