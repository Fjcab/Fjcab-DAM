package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList <Producto>();
		//creo objetos de las distintas clases para añadirlos al arraylist
		TelefonoMovil t = new TelefonoMovil("Iphone", "Apple", "128", 500, 150);
		Tablet t1 = new Tablet("Ipad", "Apple", "128", 800, 200);
		TelefonoMovil t2 = new TelefonoMovil("Galaxy", "samsung", "128", 400, 10);
		Tablet t3 = new Tablet("Galaxy", "Samsung", "128", 700, 150);
		productos.add(t);
		productos.add(t1);
		productos.add(t2);
		productos.add(t3);
		
		for (Producto p :productos) {
			System.out.println(p);
		
		}

	}

}
