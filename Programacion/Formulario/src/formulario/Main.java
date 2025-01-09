package formulario;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		int opcion;
		String nombre=null, apellidos=null, dni=null, email=null;
		Formulario f1 = new Formulario(nombre, apellidos, dni, email);
		boolean relleno=false;
		do {
		mostrarMenu();
		opcion = sc.nextInt();
		System.out.println();
		switch(opcion) {
		case 1:
			rellenarNombre(nombre, sc);
			break;
		case 2:
			rellenarApellidos(apellidos, sc);
			break;
		case 3:
			rellenarDni(dni, sc);
			break;
		case 4:
			rellenarEmail(email, sc);
			break;
		case 5:
			Formulario f2 = new Formulario(nombre, apellidos, dni, email);
			if (f1.equals(f2)) {
				System.out.println("Introduce todos los datos");
			} else {
				relleno=true;
			}
			break;
		default:
			System.out.println("Introduce un numero del 1 al 5.");
		}
		
		}while (opcion!=5 || relleno!=true);
		
		}
		
		public static void mostrarMenu(){
			System.out.println("1.Rellenar nombre");
			System.out.println("2.Rellenar apellidos");
			System.out.println("3.Rellenar DNI");
			System.out.println("4.Rellenar e-mail");
			System.out.println("5.Finalizar");
	}
		public static void rellenarNombre(String nombre, Scanner sc) {
			System.out.println("Introduce el nombre");
			nombre= sc.next();
		}
		public static void rellenarApellidos(String apellidos, Scanner sc) {
			sc.nextLine();
			System.out.println("Introduce los apellidos");
			apellidos= sc.nextLine();
		}
		public static void rellenarDni(String dni, Scanner sc) {
			System.out.println("Introduce el DNI");
			dni= sc.next();
		}
		public static void rellenarEmail(String email, Scanner sc) {
			System.out.println("Introduce el e-mail");
			email= sc.next();

	}

}
