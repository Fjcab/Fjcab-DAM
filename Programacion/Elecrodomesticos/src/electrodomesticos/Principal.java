package electrodomesticos;
import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList <Electrodomestico> listaElectro = new ArrayList<Electrodomestico>();
		int opcion;
		

		do {
		Menus.mostrarMenu();
		opcion = sc.nextInt();
		System.out.println();
		switch (opcion) {
		case 1:
			DarAlta.darAlta(sc, listaElectro);
			break;
		case 2:
			Mostrar.mostrarPrecioFinal(listaElectro);
			System.out.println();
			break;
		case 3:
			System.out.println();
			System.out.println("Fin.");
			break;
		default:
			System.out.println("Introduce un numero del 1 al 3.");
			System.out.println();
		}
		
		
		}while (opcion!=3);
		
	}
	


	
}
