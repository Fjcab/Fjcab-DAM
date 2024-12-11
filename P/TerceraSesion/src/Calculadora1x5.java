import java.util.Scanner;

public class Calculadora1x5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int operacion;
		double num1, num2;

		System.out.println("Introduce el primer numero:");
		num1=sc.nextInt();
		System.out.println();
		
		System.out.println("Selecciona el tipo de operación:");
		System.out.println("Introduce 1 para suma");
		System.out.println("Introduce 2 para resta");
		System.out.println("Introduce 3 para multiplicación");
		System.out.println("Introduce 4 para división");
		System.out.println("Introduce 5 para resto");
		operacion=sc.nextInt();
		
		System.out.println("Introduce el segundo numero:");
		num2=sc.nextInt();
		System.out.println();
		
		
		switch(operacion) {
			case 1: System.out.print(num1+num2);
				break;
			case 2: 
				if (num1>=num2) {
					System.out.print(num1-num2);
				} else {
					System.out.print(num2-num1);
				} break;
			case 3: System.out.print(num1*num2);
				break;
			case 4: System.out.print(num1/num2);
				break;
			case 5: 
				if (num2==0) {
					System.out.print("Opcion incorrecta");
					System.out.print("El divisor no puede ser 0");
				} else {
					System.out.print(num1%num2);
				} break;
			default: System.out.print("Opcion incorrecta");
		}
	}
}
