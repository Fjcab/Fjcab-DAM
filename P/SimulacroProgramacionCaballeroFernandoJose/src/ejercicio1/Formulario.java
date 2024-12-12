package ejercicio1;

import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) throws LongitudDNINoValidaException {
		Scanner sc = new Scanner(System.in);
		String usuario=null, contraseña=null, dni=null;
		int opcion;
			
		do {
			menu();
			opcion=sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduce el usuario:");
				usuario=sc.next();
				break;
			case 2:
				System.out.println("Introduce la contraseña:");
				contraseña=sc.next();
				break;
			case 3:
				System.out.println("Introduce el DNI:");
				dni=sc.next();
				try{
					if (dni.length()!=8) {
						throw new LongitudDNINoValidaException("El DNI tiene qu tener 9 digitos.");}					
				}catch(LongitudDNINoValidaException e) {
					System.out.print(e);
				}
				break;
			case 4:
				if (usuario==null || contraseña==null || dni==null) {
					System.out.println("Introduce todos los datos.");
					System.out.println();
					opcion=0;
				}
				break;
			default:
				System.out.println("Introduce un numero del 1 al 4");
			}
			
		}while (opcion!=4);
		
		System.out.println("Tu usuario es :"+usuario);
		System.out.println("Tu contraseña es :"+contraseña);
		System.out.println("Tu DNI es :"+dni);
		
	}

	public static void menu() {
		System.out.println("1.Rellenar usuario");
		System.out.println("2.Rellenar contraseña");
		System.out.println("3.Rellenar DNI");
		System.out.println("4.Finalizar");
	}
}
