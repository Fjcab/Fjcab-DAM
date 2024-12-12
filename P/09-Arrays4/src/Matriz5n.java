import java.util.Random;
import java.util.Scanner;

public class Matriz5n {

	public static void main(String[] args) {
		
		final int FILAS=5;
		int columnas;
		Scanner sc = new Scanner(System.in);
		Random random=new Random();
		System.out.print("Introduce el numero de Columnas:");
		columnas=sc.nextInt();
		int matriz[][]=new int [FILAS][columnas];
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				matriz[i][j]=random.nextInt(11);
			}
		}
		for (int i=0;i<matriz.length;i++) {
			for (int j=0;j<matriz[i].length;j++) {
				if (matriz[i][j]==10) {
					System.out.print(matriz[i][j]+"|");
				}
				else {
					System.out.print("0"+matriz[i][j]+"|");					
				}
			}
			System.out.println();
		}
	}

}
