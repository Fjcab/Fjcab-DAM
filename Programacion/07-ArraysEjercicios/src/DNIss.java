import java.util.Scanner;

public class DNIss {

	public static void main(String[] args) {
			
				Scanner sc = new Scanner(System.in);
				int numero, resto;
				final int DIV=23;
				char DNI[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
				char letra=0;
				
				
				System.out.println("Introduce tu número de DNI sin letra:");
				numero = sc.nextInt();
				resto = numero%DIV;

				letra=DNI[resto];

				System.out.println("La letra de tu DNI es: "+letra+".");
				System.out.print("Tu DNI es: "+numero+letra+".");
	}

}
