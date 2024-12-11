import java.util.Scanner;

public class Opciones {

	public static void main(String[] args) {
		int opcion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Menú de Opciones");
		System.out.println("Pulse 1 para opción 1");
		System.out.println("Pulse 2 para opción 2");
		System.out.println("Pulse 3 para opción 3");
		opcion = sc.nextInt();
		System.out.println(opcion);
		switch (opcion) {
			case 1: System.out.print("Has elegido la opción 1");
				break;
			case 2: System.out.print("Has elegido la opción 2");
				break;
			case 3: System.out.print("Has elegido la opción 3");
				break;
			default: System.out.print("Opción incorrecta");
		}
		
		
				
			
		
		
		

	}

}
