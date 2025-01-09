import java.util.Scanner;

public class Aprobado {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		double nota;
		
		System.out.println("Introduce tu nota:");
		nota=sc.nextDouble();
		
		if (nota<5) {
			System.out.println("Suspenso");
		} 
		else {
			if (nota>=5 && nota<6) {
				System.out.println("Suficiente");
			} 
			else {
				if (nota>=6 && nota<7) {
					System.out.println("Bien");
				} 
				else {
					if (nota>=7 && nota<9) {
						System.out.println("Notable");
					} 
					else {
						if (nota==9) {
							System.out.println("Sobresaliente");
						} 
						else {
							if (nota==10) {
								System.out.println("Matricula");
							} 
							else {
								if (nota>10) {
									System.out.println("Empieza de nuevo, por favor");
								} 
							}
						}
					}
				}
			}
		}

	}

}
