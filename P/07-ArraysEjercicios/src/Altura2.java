import java.util.Scanner;

public class Altura2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N, superior=0, inferior=0, igual=0;
		double suma=0, media=0;
		
		do{
		System.out.print("Indica el número de personas:");
		N = sc.nextInt();
		if (N<1) {
			System.out.print("El número debe de ser mayor que 0.");
			System.out.println();
			}
		}while (N<1);
		
		System.out.println("Por favor introduce la altura en metros.");
		double altura [] = new double [N];
		
		for (int i=0; i<altura.length; i++) {
			do {
			System.out.print("Introduce la altura de la persona nº"+(i+1)+":");
			altura[i] = sc.nextDouble();
			if (altura[i]<0 || altura[i]>=3) {System.out.println("Altura debe ser un número positivo menor que 3.");}
			}while(altura [i]<0 || altura[i]>=3);
			if (altura[i]==0) {i++;
			N--;
			inferior--;
			}
			suma+=altura[i];
			media=suma/(i+1);
			System.out.println("La media es de "+(double)Math.round(media * 100d) /100d+" m.");
		}
			media=suma/N;
		for (int i=0; i<altura.length; i++) {
			if (altura[i]>media) {superior++;}
			if (altura[i]<media) {inferior++;}
			if (altura[i]==media) {igual++;}
		}
		System.out.println();
		System.out.println("La media de altura es de "+(double)Math.round(media * 100d) / 100d+" m.");
		System.out.println();
		System.out.println("Hay "+superior+" personas con una altura superior a la media.");
		System.out.println("Hay "+inferior+" personas con una altura inferior a la media.");
		System.out.println("Hay "+igual+" personas con una altura igual a la media.");

	}
}
