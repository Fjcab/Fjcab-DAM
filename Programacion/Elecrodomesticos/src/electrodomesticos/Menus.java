package electrodomesticos;

public class Menus {
	
	public static void mostrarMenu() {
		System.out.println("Menú");
		System.out.println("1.-Dar de alta un electrodoméstico.");
		System.out.println("2.-Mostrar precio final de un todos los electrodomésticos.");
		System.out.println("3.-Salir.");
	}
	
	public static void mostrarMenuAlta() {
		System.out.println("Menú dar de Alta");
		System.out.println("1.-Dar de alta electrodoméstico.");
		System.out.println("2.-Dar de alta lavadora.");
		System.out.println("3.-Dar de alta televisión.");
	}
	
	public static void mostrarMenuElectro() {
		System.out.println("Menú electrodomésticos");
		System.out.println("1.-Introducir electrodoméstico por defecto.");
		System.out.println("2.-Introducir electrodoméstico por precio base y peso.");
		System.out.println("3.-Introducir electrodoméstico manualmente.");
	}
	public static void mostrarMenuTDT() {
		System.out.println("¿TDT?");
		System.out.println("1.SI");
		System.out.println("2.NO");
	}
}
