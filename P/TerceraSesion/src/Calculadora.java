import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int operacion;
		double num1, num2;

		System.out.println("Introduce el primer numero:");
		num1=sc.nextInt();
		System.out.println();
		
		System.out.println("Introduce el segundo numero:");
		num2=sc.nextInt();
		System.out.println();
		
		double  suma=num1+num2, resta1=num1-num2, resta2=num2-num1, multiplicacion=num1*num2, division=num1/num2, resto=num1%num2;
		System.out.println("Selecciona el tipo de operación:");
		System.out.println("Introduce 1 para suma");
		System.out.println("Introduce 2 para resta");
		System.out.println("Introduce 3 para multiplicación");
		System.out.println("Introduce 4 para división");
		System.out.println("Introduce 5 para resto");
		operacion=sc.nextInt();
		switch(operacion) {
			case 1: System.out.print(suma);
				break;
			case 2: 
				if (num1>=num2) {
					System.out.print(resta1);
				} else {
					System.out.print(resta2);
				} break;
			case 3: System.out.print(multiplicacion);
				break;
			case 4: System.out.print(division);
				break;
			case 5: 
				if (num2==0) {
					System.out.print("Opcion incorrecta");
					System.out.print("El divisor no puede ser 0");
				} else {
					System.out.print(resto);
				} break;
			default: System.out.print("Opcion incorrecta");
		}
	}
}
