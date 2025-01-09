package estructurasDeControl;

import java.util.Scanner;

public class condicional {

	public static void main(String[] args) {
		// Condicional
		/* if (condición) {
		 * 		sentencias
		 * }
		 * 
		 * if (condicion) {
		 * 		sentencias
		 * } else {
		 * 		sentencias
		 * }
		 * */
		
		int nota;
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime la nota: ");
		nota=sc.nextInt();
		/*
		//Opcion 1
		if (nota>=5) {
			System.out.print("Enhorabuena has aprobado");
		}*/
		
		
		
		
		
		
		
		
		
		
		//Opcion 2
		if(nota<5) {
			System.out.print("Suspenso");
		}
		else {
			if(nota>=5 && nota<6) {
				System.out.print("Suficiente");
			} 
			else {
				if (nota>=6 && nota<7) {
					System.out.print("Bien");
				}
				else {
					if (nota>=7 && nota<9) {
						System.out.print("Notable");
					}
					else {
						System.out.print("Sobresaliente");
					}
				}
			}
			
		}
		if(nota<5) {
			System.out.print("Suspenso");
		}
		if(nota>=5 && nota<6) {
			System.out.print("Sufiente");
		}
		if(nota<5) {
			System.out.print("Suspenso");
		}
		if(nota<5) {
			System.out.print("Suspenso");
		}
		if(nota<5) {
			System.out.print("Suspenso");
		}
		
		
		//Ejercicio de notas con letras. Suspenso, suficiente, bien, notable o sobresaliente
		
		
	}

}
