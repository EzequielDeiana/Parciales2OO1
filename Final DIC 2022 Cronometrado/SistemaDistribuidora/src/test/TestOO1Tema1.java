package test;

import java.time.LocalDate;

import modelo.SistemaDistribuidora;

public class TestOO1Tema1 {
	public static void main(String[] args) {
		///Terminado en 52.34 Minutos
		SistemaDistribuidora s1 = new SistemaDistribuidora();
		
		System.out.println("Test1)");
		
		s1.agregarCliente(4483979, "Juan", "Perez", 11111111, 500);
		s1.agregarCliente(4971920, "Marcela", "Rodriguez", 22222222, 0);
		s1.agregarCliente(7324211, 333333333, "UTT");
		s1.agregarCliente(7329827, 444444444, "Cooperativa El Grito Sagrado");
		
		System.out.println(s1.getLstCliente());
		
		System.out.println("Test2)");
		
		s1.agregarTarifa(0, 50, 300.0f, 2.0f);
		s1.agregarTarifa(51, 100, 350.0f, 2.1f);
		s1.agregarTarifa(101, 200, 450.0f, 2.5f);
		s1.agregarTarifa(201, 400, 500.0f, 3.0f);
		s1.agregarTarifa(401, 2000, 10000.0f, 4.0f);
		
		System.out.println(s1.getLstTarifa());
		
		System.out.println("Test3)");
		
		s1.agregarLectura(LocalDate.of(2021, 12, 25), s1.traerCliente(4483979), 180);
		s1.agregarLectura(LocalDate.of(2022, 1, 25), s1.traerCliente(4483979), 255);
		s1.agregarLectura(LocalDate.of(2021, 12, 25), s1.traerCliente(4971920), 100);
		s1.agregarLectura(LocalDate.of(2022, 1, 25), s1.traerCliente(4971920), 165);
		s1.agregarLectura(LocalDate.of(2021, 12, 25), s1.traerCliente(7324211), 3526);
		s1.agregarLectura(LocalDate.of(2022, 1, 25), s1.traerCliente(7324211), 4385);
		s1.agregarLectura(LocalDate.of(2021, 12, 25), s1.traerCliente(7329827), 10862);
		s1.agregarLectura(LocalDate.of(2022, 1, 25), s1.traerCliente(7329827), 11981);
		
		System.out.println(s1.getLstLectura());
		
		System.out.println("Test4)");
		System.out.println(s1.traerLectura(1, 2022, s1.traerCliente(4483979)));
		
		System.out.println("Test5)");
		System.out.println(s1.traerLectura(12, 2021, s1.traerCliente(4483979)));
		
		System.out.println("Test6)");
		System.out.println(s1.traerLectura(1, 2022, s1.traerCliente(4483979)).calcularConsumo(s1.traerLectura(12, 2021, s1.traerCliente(4483979))));
		
		System.out.println("Test7)");	
		System.out.println(s1.traerTarifa(s1.traerLectura(1, 2022, s1.traerCliente(4483979)).calcularConsumo(s1.traerLectura(12, 2021, s1.traerCliente(4483979)))));
		
		System.out.println("Test8)");	
		System.out.println(s1.calcularTotalACobrar(1, 2022, s1.traerCliente(4483979)));
		
	}
}
