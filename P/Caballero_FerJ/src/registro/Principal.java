package registro;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList <Empleado> prog = new ArrayList <Empleado>();
		String dni;
		int opcion;
		
		do {
			Metodos.mostrarMenu();
			opcion = sc.nextInt();
			System.out.println();
			switch (opcion) {
			case 1:
				System.out.println("Introduce el DNI del programador.");
				dni = sc.next();
				Metodos.darAlta(dni, sc, prog);
				break;
			case 2:
				System.out.println("Introduce el DNI del programador.");
				dni = sc.next();
				Metodos.darBaja(dni, sc, prog);
				break;
			case 3:
				System.out.println("Introduce el DNI del programador.");
				dni = sc.next();
				Metodos.aumentarSalario(dni, sc, prog);
				break;
			case 4:
				Metodos.mostrarLista(prog);
				break;
			case 5:
				System.out.println("Fin.");
				break;
			default:
				System.out.println("Introduce un numero entre 1 y 5.");
				System.out.println();
			}
		}while (opcion!=5);

	}

}
