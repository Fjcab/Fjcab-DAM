import java.util.Scanner;

public class ArrAprobados {

	public static void main(String[] args) {
		
		int notas, suspensos=0, aprobados=0;
		double arrayNotas [];
		Scanner sc = new Scanner (System.in);
		
		System.out.print("¿Cuántas notas vas a introducir?");
		notas=sc.nextInt();
		arrayNotas = new double[notas];
		
		//Preguntar las notas y guardarlas en mi array.
		for(int i=0; i<arrayNotas.length; i++){
			System.out.print("Dime la nota:");
			arrayNotas[i]=sc.nextDouble();
		}//for
		//Recorrer el array para ver las notas y saber si esta suspemso o aprobado.
		for(int i=0; i<arrayNotas.length; i++) {
			if(arrayNotas[i]<5) {
				suspensos++;
			}else aprobados++;
		}//for2
		System.out.println("El numero de suspensos es: "+suspensos);
		System.out.println("El numero de aprobados es: "+aprobados);

	}

}
