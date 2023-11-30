package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import modelo.DescuentoPorSubTotal;
import modelo.Sistema;
import modelo.descuentoPorCantidad;

public class Test {

	public static void main(String[] args) {
		System.out.println("Test suite Sistema Tema 1");

		// objeto sistema
		Sistema s1 = new Sistema();

		// UC 1 --------------------------------------------
		System.out.println("\nUC 1");
		try {
			s1.agregarArticulo("art1", 100.0, new descuentoPorCantidad(true, 5, 3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s1.agregarArticulo("art2", 150.0, new descuentoPorCantidad(true, 5, 2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s1.agregarArticulo("art3", 200.0, new DescuentoPorSubTotal(false, 500, 10));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s1.agregarArticulo("art4", 500.0, new DescuentoPorSubTotal(true, 1000, 50));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(s1.getArticulos());

		// UC 2 --------------------------------------------
		System.out.println("\nUC 2");
		try {
			s1.agregarArticulo("art1", 100.0, new descuentoPorCantidad(true, 5, 3));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// UC 3 --------------------------------------------
		System.out.println("\nUC 3");
		try {

			s1.agregarCompra(6, s1.traerArticulo("art1"), LocalDateTime.of(2023, 10, 20, 9, 00));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s1.agregarCompra(5, s1.traerArticulo("art2"), LocalDateTime.of(2023, 10, 20, 9, 30));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s1.agregarCompra(10, s1.traerArticulo("art2"), LocalDateTime.of(2023, 10, 20, 10, 00));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s1.agregarCompra(3, s1.traerArticulo("art3"), LocalDateTime.of(2023, 10, 20, 10, 30));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s1.agregarCompra(4, s1.traerArticulo("art4"), LocalDateTime.of(2023, 10, 20, 11, 00));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(s1.getCompras());

		// UC 4 --------------------------------------------
		System.out.println("\nUC 4");
		try {
			s1.agregarCompra(0, s1.traerArticulo("art1"), LocalDateTime.of(2023, 10, 20, 9, 00));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// UC 5 --------------------------------------------
		System.out.println("\nUC 5");
		System.out.println(s1.getCompras().get(2));
		System.out.println(s1.getCompras().get(2).precioTotal());
		System.out.println(s1.getCompras().get(3));
		System.out.println(s1.getCompras().get(3).precioTotal());
		System.out.println(s1.getCompras().get(4));
		System.out.println(s1.getCompras().get(4).precioTotal());

		// UC 6 --------------------------------------------
		System.out.println("\nUC 6");
		System.out.println(s1.traerCompras(LocalDateTime.of(LocalDate.of(2023, 10, 20), LocalTime.of(9, 15)),
				LocalDateTime.of(LocalDate.of(2023, 10, 20), LocalTime.of(10, 30))));

		// UC 7 --------------------------------------------
		System.out.println("\nUC 7");
		System.out.println(
				s1.traerComprasdescuentoPorcantidad(LocalDateTime.of(LocalDate.of(2023, 10, 20), LocalTime.of(9, 15)),
						LocalDateTime.of(LocalDate.of(2023, 10, 20), LocalTime.of(10, 30))));

		// UC 8 --------------------------------------------
		System.out.println("\nUC 8");
		System.out.println(s1.traerArticuosconDescuento(true));
	}

}
