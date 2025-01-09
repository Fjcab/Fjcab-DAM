package Hotel;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String usuario, contraseña, menu , opcion;
		ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
		ArrayList <Habitacion> habitaciones = new ArrayList <Habitacion>();
		ArrayList <Reserva> reservas = new ArrayList <Reserva>();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		Lista l = new Lista();
		Menus m = new Menus();
		Gestion g = new Gestion();
		
		l.listaUsuarios(usuarios);
		l.listaHabitaciones(habitaciones);
		l.listaReservas(reservas);
		
		do {
			m.menuPrincipal();
			menu=sc.next();
			switch(menu) {
			case "1":		
				System.out.println("Introduce tu nombre de usuario:");
				usuario = sc.next();
				System.out.println("Introduce tu contraseña:");
				contraseña = sc.next();
				
				if (g.comprobarUsuario(usuario, contraseña, usuarios)) {

					if (g.comprobarAdmin(usuario, usuarios)){
						do {
							do {
								m.menuAdmin();
								opcion=sc.next();
								if (!g.isNumeric(opcion))System.out.println("Introduce un número.");
							}while(!g.isNumeric(opcion));
							switch(opcion) {
							case "1":
								g.altaHabitacion(m, sc, habitaciones);
								break;
							case "2":
								g.bajaHabitacion(sc, habitaciones);
								break;
							case "3":
								g.modHabitacion (m, sc, habitaciones);
								break;
							case "4":
								g.mostrarReservas(reservas, formatoFecha);
								break;
							case "5":
								g.mostrarHabitaciones(m, sc, habitaciones);
								break;
							case "6":
								g.mostrarResClientes(sc, usuarios, reservas, formatoFecha);
								break;
							case "7":
								System.out.println("Vuelta al menú principal.");
								break;
							default:
								System.out.println("Introduce un número del 1 al 7.");
							}
						}while (!opcion.equals("7"));
					}else {
						do {
							do {
								m.menuCliente();
								opcion=sc.next();
								if (!g.isNumeric(opcion))System.out.println("Introduce un número.");
							}while(!g.isNumeric(opcion));
							switch(opcion) {
							case"1":
								g.Reservar(m, sc, formatoFecha, habitaciones, reservas, usuario);
								break;
							case "2":
								g.mostrarHabitaciones(m, sc, habitaciones);
								break;
							case "3":
								g.mostrarMisReservas(usuario, reservas, formatoFecha);
								break;
							case "4":
								System.out.println("Vuelta al menú principal.");
								break;
							default:
								System.out.println("Introduce un número del 1 al 4.");
							}
						}while (!opcion.equals("4"));
					}
				}else System.out.println("El usuario no existe");
				break;
			case "2":
				g.mostrarUsuarios(usuarios);
				break;
			case "3":
				System.out.println("Fin");
				break;
			default:
				System.out.println("Introduce un número del 1 al 3.");
			}		
		}while(!menu.equals("3"));
	}
}
