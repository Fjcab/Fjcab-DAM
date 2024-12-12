//Guardar en un array los números de bastidores de los coches que entran en un taller para su reparación.
/*1.- Array cuando se crea null
 * 2.- ¿Cómo termino la ejecución de un bucle?
 */

import java.util.Scanner;

public class bastidores {
	public static void main(String[] args) {
		
		String bastidores [] = new String [100];
		String bastidor;
		Scanner sc = new Scanner (System.in);
		
		//Pido un número de bastidor para guardar
		System.out.print("Dime el número de bastidor: ");
		bastidor=sc.next();
		for (int i=0; i<bastidores.length; i++) {
			if (bastidores[0]==null) {
				bastidores[i]=bastidor;
				System.out.print("Bastidor guaradado correctamente");
				//break;
				i=bastidores.length;//Poner el primer valor que no se cumple en la condición del bucle for.
			}//if
		}//for
		//Pido un número de bastidor borrar
		System.out.println();
		System.out.print("Dime el número de bastidor: ");
		bastidor=sc.next();
		for (int i=0; i<bastidores.length; i++) {
			if (bastidores[i]!=null && bastidores[i].equals(bastidor)) {
				bastidores[i]=null;
				System.out.print("Bastidor eliminado correctamente");
				//break;
				i=bastidores.length;//Poner el primer valor que no se cumple en la condición del bucle for.
			}//if
		}//for
	}//main
}
