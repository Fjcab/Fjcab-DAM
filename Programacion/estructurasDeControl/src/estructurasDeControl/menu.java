package estructurasDeControl;

import java.util.Scanner;

public class menu {

	public static void main(String[] args) {
		int opcion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menú de opciones");
		System.out.println("1.- Opcion 1");
		System.out.println("2.- Opcion 2");
		System.out.println("3.- Opcion 3");
		opcion = sc.nextInt();
		System.out.println(opcion);
		switch(opcion) {
			case 1: System.out.print("Has elegido la opcion 1");
				break;
			case 2: System.out.print("Has elegido la opcion 2");
				break;
			case 3: System.out.print("Has elegido la opcion 3");
				break;
			default: System.out.print("Opcion incorrecta");
		}
/*
		char letra;
		System.out.println("Menú de opciones");
		System.out.println("Salir");
		System.out.println("Entrar");
		letra=sc.next().toUpperCase().charAt(0);
		switch(letra) {
				case 'S': //sentencias
					break;
				case 'E': //sentencias
					break;
				default: System.out.print("Opcion incorrecta");
		}*/
		
		
	}

}
