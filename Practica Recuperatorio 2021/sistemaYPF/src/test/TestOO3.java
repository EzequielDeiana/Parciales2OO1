package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.SistemaYPF;

public class TestOO3 {
	public static void main(String[] args) {
		SistemaYPF ypf = new SistemaYPF();
		
		System.out.println("1)");
		
		try {
			ypf.agregarTarjeta("ABCDEFG123456", "DNI11222333");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ypf.agregarTarjeta("ABCDE1234567,", "DNI11222333");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ypf.agregarTarjeta("ABCDEFG12345", "DNI11222333");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("2)");
		try {
			ypf.agregarTarjeta("ABCDEF123456", "DNI11222333");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ypf.agregarTarjeta("GHIJKL987654", "DNI44555666");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			ypf.agregarTarjeta("MNOPQR456654", "DNI77888999");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ypf.traerTarjeta("DNI11222333"));
		System.out.println(ypf.traerTarjeta("DNI44555666"));
		System.out.println(ypf.traerTarjeta("DNI77888999"));
		
		System.out.println("3.1)");
		
		ypf.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 9, 10), LocalTime.of(10, 30), 100.0, 25.0, 20.0);
		ypf.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 10, 1), LocalTime.of(20, 30), 200.0, 40.0, 50.0);
		ypf.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 9, 15), LocalTime.of(10, 30), 100.0, 30.0, "MODO", 500.0);
		ypf.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 10, 1), LocalTime.of(20, 30), 200.0, 20.0, "MODO", 500.0);
		
		System.out.println(ypf.traerTarjeta("DNI11222333"));
		
		System.out.println("3.2)");
		
		ypf.traerTarjeta("DNI44555666").agregarCompra(LocalDate.of(2021, 9, 16), LocalTime.of(15, 0), 100.0, 35.0, 20.0);
		System.out.println(ypf.traerTarjeta("DNI44555666"));
		
		System.out.println("3.3)");
		
		ypf.traerTarjeta("DNI77888999").agregarCompra(LocalDate.of(2021, 9, 16), LocalTime.of(15, 0), 100.0, 35.0, "MERCADO PAGO", 1000.0);
		System.out.println(ypf.traerTarjeta("DNI77888999"));
		
		System.out.println("4)");
		System.out.println(ypf.traerTarjeta("DNI11222333").getCalcularPuntajeFinal());
		
		System.out.println("5)");
		System.out.println(ypf.traerTarjeta("DNI11222333").calcularPuntaje(LocalDate.of(2021, 10, 1)));
		
		System.out.println("6)");
		System.out.println(ypf.traerTarjeta("DNI11222333").calcularPuntaje(2021, 9));
		
		System.out.println("7)");
		System.out.println(ypf.traerTarjetasComprasEfectivo(LocalDate.of(2021, 8, 1), LocalDate.of(2021, 11, 1)));
		
		
	}
	
	
}
