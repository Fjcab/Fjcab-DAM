package Ejercicio1;

import java.util.Scanner;


public class Formulario {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre=null, apellido=null, dni=null;
		//los atributos deberian pertenecer a una clase Persona pero no la he creado por falta de tiempo
		//Damos valor a los atributos para que no de error en el if de salida

			int opcion=0;

			do {			
				menu();
				opcion=sc.nextInt();
				
				switch(opcion) {
				case 1:
					System.out.println("Escribe tu nombre:");
					apellido=sc.nextLine();
					sc.nextLine();
					break;
				case 2:
					System.out.println("Escribe tus apellidos:");
					apellido=sc.nextLine();
					sc.nextLine();
					break;
				case 3:
					System.out.println("Escribe el DNI:");
					try {
						dni=sc.nextLine();
						LongitudDNINoValidaException.validarDNI(dni);
						UltimoDigitoNoLetraException.comprobarDNI(dni);
				    } catch (IllegalArgumentException e) {
				    	//capturamos las excepciones
				        System.out.println(e.getMessage());
				    }
					break;
				case 4:
					if (nombre==null || apellido==null || dni==null) {
						//condición de salida
						System.out.println("Introduce todos los datos.");
						System.out.println();
						
						opcion=0;
					}else {
						System.out.print("Fin");
					}
					break;
				default:
					System.out.print("Introduce un numero del 1 al 4.");
				}
			}while(opcion!=4);
			
			System.out.print("Tu nombre es: "+nombre+" "+apellido);
			System.out.print("Tu DNI es: "+dni);
			
			
			
	}
	
	public static void menu() {
		System.out.println("1. Rellenar nombre.");
		System.out.println("2. Rellenar apellidos.");
		System.out.println("3. Rellenar DNI.");
		System.out.println("4. Finalizar.");
	}
}
