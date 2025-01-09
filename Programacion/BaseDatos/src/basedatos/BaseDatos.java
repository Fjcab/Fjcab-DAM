package basedatos;

import java.sql.SQLException;
import java.util.Scanner;

public class BaseDatos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion, nombre=null, contraseña=null;
		
		Gestion g = new Gestion();
		
		do {	
			menu();
			opcion = sc.next();
			switch(Integer.valueOf(opcion)) {
			case 1:
				insertar(g, sc, nombre, contraseña);
				break;
			case 2:
				comprobar(g, sc, nombre, contraseña);
				break;
			case 3:
				borrar(g, sc, nombre, contraseña);
				break;
			case 4:
				System.out.println("Fin.");
				break;
			default:
				System.out.println("Introduce un numero del 1 al 4.");
				System.out.println();
			}
			
		}while(Integer.valueOf(opcion)!=4);
		

	}
	
	public static void menu() {
		System.out.println("MENÚ");
		System.out.println("1.Registrar usuario");
		System.out.println("2.Buscar usuario");
		System.out.println("3.Eliminar usuario");
		System.out.println("4.Salir");
	}
	public static void insertar(Gestion g, Scanner sc, String nombre, String contraseña){
		System.out.println("Introduce el nombre del Usuario a insertar:");
		nombre = sc.next();
		System.out.println("Introduce la contraseña:");
		contraseña = sc.next();
		System.out.println(nombre+" "+contraseña);
		System.out.println();		
		try {
			if (!g.comprobarUsuario(contraseña, contraseña)) {
				g.insertarUsuario(nombre, contraseña);
			}
			else {
				System.out.println("El usuario ya está en el sistema");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		}

	
	public static void comprobar(Gestion g, Scanner sc, String nombre, String contraseña){
		System.out.println("Introduce el nombre del Usuario a insertar:");
		nombre = sc.next();
		System.out.println("Introduce la contraseña:");
		contraseña = sc.next();
		System.out.println(nombre+" "+contraseña);
		System.out.println();			
		try {		
			if (g.comprobarUsuario(nombre, contraseña)) {
				System.out.println("El usuario está en el sistema");
				System.out.println();
			}else {
				System.out.println("El usuario no está en el sistema");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void borrar(Gestion g, Scanner sc, String nombre, String contraseña){
		System.out.println("Introduce el nombre del Usuario a eliminar:");
		nombre = sc.next();
		System.out.println(nombre);
		System.out.println("Introduce la contraseña:");
		contraseña = sc.next();
		System.out.println();		
		
		try {
			if (g.comprobarUsuario(nombre, contraseña)) {
				g.eliminarUsuario(nombre);
				System.out.println("El usuario ha sido eliminado");
				System.out.println();
			}else {
				System.out.println("El usuario no está en el sistema");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
