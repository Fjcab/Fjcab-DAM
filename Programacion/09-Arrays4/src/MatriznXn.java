import java.util.Scanner;

public class MatriznXn {
	public static void main(String[] args) {
	
		int filas, columnas;
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce el numero de filas:");
		filas=sc.nextInt();
		System.out.println("Introduce el numero de columnas:");
		columnas=sc.nextInt();
		
		double matriz[][]=new double[filas][columnas];
		double matriz2[][]=new double[filas][columnas];
		double matriz3[][]=new double[filas][columnas];
		
		System.out.println();
		System.out.println("Matriz 1");
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				System.out.print("Introduce el valor de la posición "+(i+1));
				System.out.println("|"+(j+1)+":");
				matriz[i][j]=sc.nextDouble();
			}
		}
		System.out.println();
		System.out.println("Matriz 2");
		for (int i=0;i<matriz2.length;i++) {
			for (int j=0;j<matriz2[i].length;j++) {
				System.out.print("Introduce el valor de la posición "+(i+1));
				System.out.println("|"+(j+1)+":");
				matriz2[i][j]=sc.nextDouble();
			}
		}
		for (int i=0;i<matriz3.length;i++) {
			for (int j=0;j<matriz3[i].length;j++) {
				matriz3[i][j]=matriz[i][j]+matriz2[i][j];
			}
		}
		
		System.out.println();
		System.out.println("Matriz 1");
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				System.out.print(matriz[i][j]+"|");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Matriz 2");
		for (int i=0;i<matriz2.length;i++) {
			for (int j=0;j<matriz2[i].length;j++) {
				System.out.print(matriz2[i][j]+"|");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Suma");
		for (int i=0;i<matriz3.length;i++) {
			for (int j=0;j<matriz3[i].length;j++) {
				System.out.print((double)Math.round(matriz3[i][j] * 100d) / 100d+"|");
			}
			System.out.println();
		}
		
	}
}
