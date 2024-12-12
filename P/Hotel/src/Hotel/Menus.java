package Hotel;

public class Menus {
	
	protected void menuPrincipal() {
		System.out.println();
		System.out.println("1.-Introducir usuario");
		System.out.println("2.-Mostrar usuarios.");
		System.out.println("3.-Salir.");	
	}
	
	protected void menuAdmin() {
		System.out.println();
		System.out.println("1.-Dar de alta una habitación.");
		System.out.println("2.-Dar de baja una habitación.");
		System.out.println("3.-Modificar los datos de una habitación.");
		System.out.println("4.-Ver habitaciones reservadas.");
		System.out.println("5.-Ver habitaciones.");
		System.out.println("6.-Ver las reservas un cliente.");
		System.out.println("7.-Volver al menú principal.");
	}
	
	protected void menuCliente() {
		System.out.println();
		System.out.println("1.-Reservar una habitación.");
		System.out.println("2.-Ver habitaciones.");
		System.out.println("3.-Ver mis reservas.");
		System.out.println("4.-Salir");
	}
	
	protected void menuMod() {
		System.out.println();
		System.out.println("¿Que quieres modificar?");
		System.out.println("1.-Numero de la habitación.");
		System.out.println("2.-Precio de la habitación.");
		System.out.println("3.-Volver al menú principal.");
	}
	
	protected void menuRecuerda() {
		System.out.println("¡¡¡RECUERDA!!!");
		System.out.println("Nº de habitación que empieza por 1-INDIVIDUAL.");
		System.out.println("Nº de habitación que empieza por 2-DOBLE.");
		System.out.println("Nº de habitación que empieza por 3-FAMILIAR.");
	}
	
	protected void menuMostrar() {
		System.out.println();
		System.out.println("1.-Mostrar todas las habitaciones.");
		System.out.println("2.-Mostrar las habitaciones individuales.");
		System.out.println("3.-Mostrar las habitaciones dobles.");
		System.out.println("4.-Mostrar las habitaciones familiares.");
	}
}
