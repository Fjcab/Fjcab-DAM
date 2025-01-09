import java.util.Scanner;

public class DNIs2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String dato, num, let;
		int numero;
		final int div=23;
		double resto;
		char DNI[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		char letra=0;
		
		
		System.out.println("Introduce tu DNI:");
		dato = sc.next();
		num = dato.substring(0, 8);
		let = dato.substring(8);
		
		System.out.println("Tu número de DNI es: "+num);
		System.out.println("Tu letra de DNI es: "+let);
		
		numero = Integer.parseInt(num);
		resto = numero%div;
		
		System.out.println("El resto es: "+resto);
		
		for (int i=0; i<DNI.length; i++) {
			if (resto==i) {
				letra=DNI[i];
				i=DNI.length;
				}
		}
		System.out.println("La letra de tu DNI es: "+letra);
		System.out.print("Tu DNI es: "+numero+letra);

	}

}
