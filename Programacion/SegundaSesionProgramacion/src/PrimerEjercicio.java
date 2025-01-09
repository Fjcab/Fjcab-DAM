import java.util.Scanner;

public class PrimerEjercicio {

	public static void main(String[] args) {
		
		// Variables.
		int num1=4, num2=8, suma=num1+num2, resta=num2-num1, multiplicacion=num1*num2, 
				cociente=num2/num1, resto=num2%num1;
		double numero1=4.0, numero2=6.0, suma2=numero1+numero2, resta2=numero2-numero1,
				multiplicacion2=numero1*numero2, cociente2=numero2/numero1, 
				resto2=numero2%numero1;
		char letra='d';
		String palabra="Fernando Caballero";
		boolean verdadero = false;
		
	
		// Constantes.
		final int VALOR=8;
		
		//Peticion de datos
		System.out.println("Hola "+palabra+" bienvenido a Java");
		System.out.println("la multipliacion es: "+multiplicacion);
		System.out.println("El resultado del resto es: "+resto2);
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Dime un numero: ");
		int oper1=sc.nextInt(), oper2=oper1*cociente;
		System.out.println("Tu numero es: "+oper2);
		System.out.println("Dime tu nombre: ");
		String nombre = sc.next();
		System.out.print("No, tu nombre no es "+nombre+" tu nombre es "+palabra);
		
	}

}
