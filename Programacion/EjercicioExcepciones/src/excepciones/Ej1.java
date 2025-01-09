package excepciones;

import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero = Integer.MIN_VALUE;
		int mayor=0;
		
		for (int i=0;i<6; i++) {
			int posicion= i+1;
			boolean datoInt = false;
			do {
				try {
				System.out.println("Introduce el numero "+ posicion +":");
				numero = Integer.parseInt(sc.nextLine());
				datoInt=true;
				}catch(Exception e) {					
				System.out.println("Error");
				}
				
			}while(!datoInt);
			
			if(numero>mayor) mayor=numero;
		}
		System.out.println(mayor);

	}

}
