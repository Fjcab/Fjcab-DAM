package ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		ArrayList <Producto> productos = new ArrayList <Producto>();
		
		Producto t1 = new TelefonoMovil (1000,"Iphone","Apple", 128,10);
		Producto t2 = new TelefonoMovil (500,"Galaxy","Samsung", 256,50);
		Producto b1 = new Tablet (1100,"Ipad","Apple", 256,10);
		Producto b2 = new Tablet(1000,"Ipad","Apple", 128,50);
		
		productos.add(t1);
		productos.add(t2);
		productos.add(b1);
		productos.add(b2);
		
		for (Producto p: productos) {
			System.out.println(p.toString());
		}
	}

}
