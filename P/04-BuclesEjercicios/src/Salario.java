import java.util.Scanner;

public class Salario {

	public static void main(String[] args) {

		int opcion, numTra, salario=0;
		char clase;
		final int claseA=25, claseB=20, claseC=15, claseD=10;
		Scanner sc = new Scanner(System.in); 
		
		do {
			System.out.println("1.-Calcular salario.");
			System.out.println("2.-Salir.");
			opcion=sc.nextInt();
			if(opcion!=2) {
				System.out.println("¿Numero de horas trabajadas?");
				numTra=sc.nextInt();
				System.out.println("¿A que clase perteneces?");
				clase=sc.next().charAt(0);
				switch (clase) {
					case 'A' : salario=numTra*claseA;
						break; 
					case 'B' : salario=numTra*claseB;
						break;
					case 'C' : salario=numTra*claseC;
						break;
					case 'D' : salario=numTra*claseD;
						break;
					default: System.out.print("Clase incorrecta, no te puedo calcular el salario");
				}//switch
				System.out.println("Tú salario es: "+salario+"€");
			}//if
		}while (opcion!=2);
		System.out.print("Fin");
	}

}
