import java.util.Scanner;

public class Enteros {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int arrenteros [] = new int [10];
		int positivo=0, negativo=0, cero=0;
		
		for (int i=0; i<arrenteros.length; i++) {
			System.out.print("Añade el valor de "+(i+1)+":");
			arrenteros[i] = sc.nextInt();
			/*if (arrenteros[i]>0) {positivo++;}
			if (arrenteros[i]<0) {negativo++;}
			if (arrenteros[i]==0) {cero++;}*/
		}
		for (int i=0; i<arrenteros.length; i++) {
			if(arrenteros[i]>0) {positivo++;}
			if(arrenteros[i]<0) {negativo++;}
			if(arrenteros[i]==0) {cero++;}
		}
		System.out.println("Hay "+positivo+" números positivos.");
		System.out.println("Hay "+negativo+" números negativos.");
		System.out.println("Hay "+cero+" ceros.");
	}

}
