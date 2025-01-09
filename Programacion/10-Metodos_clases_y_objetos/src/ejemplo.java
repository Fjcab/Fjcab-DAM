import java.util.Scanner;

public class ejemplo {

	public static void main(String[] args) {

		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Dime el primer número");
		num1=sc.nextInt();
		System.out.print("Dime el segundo número");
		num2=sc.nextInt();
	
		//Llamar al método de sumar
		int suma = SumarValores(num1,num2);
		
		String notas[] = new String[3];
		System.out.println(notas[1]);
		insertarNotas(notas, sc);
		System.out.println(notas[1]);
	}
	/* public static tipoRetorno nombreDelMetodo (atributos){
	 * 	//Lineas de código.
	 * }
	 * */
	public static int/*void*/ SumarValores (int operando1, int operando2) {
		int suma = operando1 + operando2;
		System.out.print("La suma es: "+suma);
		return suma;
	}
	//Paso por valor. Copia del contenido, no vinculada entre ellas.
	//Paso por referencia. Vinculados.
	
	public static void insertarNotas(String notasAlumnos[], Scanner sc) {
		notasAlumnos[0]="5";
		notasAlumnos[1]="4";
		notasAlumnos[2]="7";
	}
}
