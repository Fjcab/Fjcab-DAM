package excepciones;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=0;
		int array[];
		boolean datoInt = false;
		do {		
			System.out.println("Introduce la longitud del Array:");
			try {
				n = Integer.parseInt(sc.nextLine());
				datoInt=true;
			}catch(Exception e) {
				System.out.println("Error");
			}
		}while (!datoInt);
		array = new int [n];
		
		crearArray(sc, n, array);
		/*		 
		for (int i=0;i<array.length;i++) {
			System.out.println("posicion"+i+":"+array[i]);
		}
		 */
		try {
		System.out.println("La media es: "+calcMedia(n, array));
		}catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
			sc.nextLine();	
		}


	}
	public static double calcMedia(int n, int array []){
		if (array==null || array.length==0) {
			throw new IllegalArgumentException("El array no puede estar vacío");
		}
		double num=0;
		double media;
		for (int i=0;i<array.length;i++) {
			num+=array[i];		
		}
		media = num/n; 
		System.out.println("numero "+num+ " div entre " +n+ " = "+media);
		return media;
	}
	
	public static void crearArray(Scanner sc,int n, int array []) {
		for (int i=0;i<array.length;i++) {
			int posicion = i+1;
			boolean datoInt = false;
			do {
			try {
				System.out.println("Introduce el numero "+posicion+":");	
				array [i] = Integer.parseInt(sc.nextLine());	
				datoInt=true;
			}catch(Exception e) {
				System.out.println("Error");
			}

			}while(!datoInt);
		}
	}

}
