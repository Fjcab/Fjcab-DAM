import java.util.Scanner;

public class Tarea1X {

	private static final String Final = null;

	public static void main(String[] args) {
		// Variables y Constantes
		Scanner sc = new Scanner (System.in);
		String nombre;
		final int ASIGNATURAS=3;
		int nota1, nota2, nota3;
		
		//Peticion de datos
		System.out.println("Introduce tu nombre por favor:");
		nombre=sc.next();
		System.out.println();
		
		System.out.println("Introduce tu nota de matemáticas:");
		nota1=sc.nextInt();
		
		System.out.println("Introduce tu nota de lengua:");
		nota2=sc.nextInt();
		
		System.out.println("Introduce tu nota de inglés:");
		nota3=sc.nextInt();
	
		int suma=(nota1+nota2+nota3), media=(suma/ASIGNATURAS);
		
		//Mostrar Resultados
		System.out.print("Tu nota es: "+media);
		

	}

}
