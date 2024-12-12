import java.util.Scanner;

public class notas {

	public static void main(String[] args) {
		
		int total;
		double nota, max=0, min=10, suma=0, media;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Cuántas notas quieres introducir?");
		total = sc.nextInt();
		
		for (int i=total; i>=1; i--) {
			do {
			System.out.println("Introduce nota:");
			nota = sc.nextDouble();
				if (nota>10) {System.out.println("Tienes que introducir un número entre 0 y 10");}
			
			}while (nota>10);
			
			if (nota>max) {max=nota;}
			if (nota<min) {min=nota;}
			suma+=nota;
		}//for
		media=suma/total;
		System.out.println("La nota mas alta es un "+max);
		System.out.println("La nota mas baja es un "+min);
		System.out.println("La nota media es "+(double)Math.round(media * 100d) / 100d); 
	}

}
