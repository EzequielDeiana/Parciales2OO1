package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modulo.Cliente;
import modulo.Empleado;
import modulo.SistemaCallCenter;

public class testTema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaCallCenter s1 = new SistemaCallCenter();
		
		System.out.println("1)");
		
		try {
			s1.agregarCliente("Luis", "Perez", 11111111, LocalDate.of(2020, 1, 1), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarCliente("Lucas", "Pereyra", 22222222, LocalDate.of(2020, 2, 1), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarEmpleado("Pedro", "Gomez", 33333333, LocalDate.of(2020, 2, 11), 10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarEmpleado("Pablo", "Lopez", 44444444, LocalDate.of(2022, 3, 15), 9000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s1.getLstPersona());
		
		System.out.println("2)");
		
		try {
			s1.agregarLlamada(LocalDate.of(2022, 11, 6), LocalTime.of(10, 10), (Cliente)s1.traerPersona(11111111), (Empleado)s1.traerPersona(33333333), 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 10), (Cliente)s1.traerPersona(11111111), (Empleado)s1.traerPersona(33333333), 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 15), (Cliente)s1.traerPersona(22222222), (Empleado)s1.traerPersona(33333333), 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s1.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 20), (Cliente)s1.traerPersona(11111111), (Empleado)s1.traerPersona(44444444), 3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(s1.getLstLlamada());
		
		System.out.println("3)");
		
		System.out.println(s1.traerClientes(true));
		
		System.out.println("4)");
		
		System.out.println(s1.traerPersonasAntiguedad(2));
		
		System.out.println("5)");
		
		System.out.println(s1.traerLlamadas(LocalDate.of(2022, 11, 7), LocalTime.of(10, 10), LocalTime.of(10, 18)));
		
		System.out.println("6)");
		
		try {
			System.out.println(s1.agregarCliente("Marcos", "Rios", 22222222, LocalDate.of(2020, 2, 1), true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("7)");
		
		try {
			s1.agregarEmpleado("Miguel", "Martinez", 44444444, LocalDate.of(2020, 2, 1), 9500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("8)");
		
		try {
			s1.agregarLlamada(LocalDate.of(2022, 11, 7), LocalTime.of(10, 30), (Cliente)s1.traerPersona(11111111), (Empleado)s1.traerPersona(33333333), 8);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
