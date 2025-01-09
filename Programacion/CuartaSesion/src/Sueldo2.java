import java.util.Scanner;

public class Sueldo2 {

	public static void main(String[] args) {

		int sueldo, horas, clase;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Si eres un trabajador de clase A introduce 1:");
			System.out.println("Si eres un trabajador de clase B introduce 2:");
			System.out.println("Si eres un trabajador de clase C introduce 3:");
			System.out.println("Si eres un trabajador de clase D introduce 4:");
			System.out.println("Para salir introduce 5:");
			clase = sc.nextInt();
			
			if (clase!=5) {
				if(clase>5) {System.out.println("Por favor introduce un numero entre 1 y 5:");
					System.out.println("");}
				else {
			do {
			System.out.println("Introduce el numero de horas trabajadas esta semana:");
			horas = sc.nextInt();
			if (horas>40) {System.out.println("El numero de horas trabajadas debe ser menor a 40.");
			System.out.println("");
				}//if horas
			}while (horas>40);//do horas
			
			switch(clase) {
			
			case 1: 
				sueldo=25;
				System.out.println("Tu sueldo esta semana es de: "+sueldo*horas);
				System.out.println("");
			break;
		
			case 2:
				sueldo=20;
				System.out.println("Tu sueldo esta semana es de: "+sueldo*horas);
				System.out.println("");
			break;
			
			case 3:
				sueldo=15;
				System.out.println("Tu sueldo esta semana es de: "+sueldo*horas);
				System.out.println("");
			break;
			
			case 4:
				sueldo=10;
				System.out.println("Tu sueldo esta semana es de: "+sueldo*horas);
				System.out.println("");
			break;
			}//Switch			
				}
			}//if Class!5
				}while (clase!=5);//primer do
		System.out.println("Fin");
	}//main

}//public class
