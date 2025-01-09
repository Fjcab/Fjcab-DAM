  import java.util.Scanner;

public class calculadora2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int operacion, continuar;
		double num1, num2;
		
		
		System.out.println("Introduce el primer número:");
		num1 = sc.nextDouble();
		
		do{
		System.out.println("Introduce 1 para Suma." );
		System.out.println("Introduce 2 para Resta." );
		System.out.println("Introduce 3 para Multiplicación." );
		System.out.println("Introduce 4 para División." );
		System.out.println("Introduce 5 para Resto." );
		operacion = sc.nextInt();
			
			if(operacion==0) {operacion=6;}
			if(operacion>5) {
				System.out.println("");
				System.out.println("Introduce un número entre 1 y 5:");
				System.out.println("");
				System.out.println(num1);
				}//if op>6
			else {
		System.out.println("Introduce el segundo número:");
		num2 = sc.nextDouble();
		
		switch(operacion) {
			case 1: 
				System.out.print(num1+" + "+num2+" = ");
				System.out.println(num1+num2);
				System.out.println();
				
				do {
				System.out.println("Introduce 1 para continuar con el resultado anterior.");
				System.out.println("Introduce 2 para empezar desde el principio.");
				System.out.println("Introduce 0 para salir.");
				continuar = sc.nextInt();
				System.out.println();
				
				switch (continuar) {
					
					case 0:
						operacion=0;
					break;
				
					case 1 :
						System.out.println(num1+=num2);
					break;
				
					case 2 :
						System.out.println("Introduce el primer número:");
						num1 = sc.nextDouble();
					break;
					
					default:
						System.out.println("Por favor, introduce 1, 2 o 0.");
						System.out.println();
				}//switch continuar 
				}/*do continuar*/while (continuar>2);
			break;
			
			case 2: 
				if(num1>=num2) { 
					System.out.print(num1+" - "+num2+" = ");
					System.out.println(num1-num2);
					System.out.println();
				
				do {
				System.out.println("Introduce 1 para continuar con el resultado anterior.");
				System.out.println("Introduce 2 para empezar desde el principio.");
				System.out.println("Introduce 0 para salir.");
				continuar = sc.nextInt();
				System.out.println();
				
				switch (continuar) {
					
					case 0:
						operacion=0;
					break;
				
					case 1 :
						System.out.println(num1-=num2);
					break;
				
					case 2 :
						System.out.println("Introduce el primer número:");
						num1 = sc.nextDouble();
					break;
					
					default:
						System.out.println("Por favor, introduce 1, 2 o 0.");
						System.out.println();	
				}//switch continuar 
				}/*do continuar*/while (continuar>2);
				}//if resta
				else { 
					System.out.print(num2+" - "+num1+" = ");
					System.out.println(num2-num1);
					System.out.println();
				do {
				System.out.println("Introduce 1 para continuar con el resultado anterior.");
				System.out.println("Introduce 2 para empezar desde el principio.");
				System.out.println("Introduce 0 para salir.");
				continuar = sc.nextInt();
				System.out.println();
				
				switch (continuar) {
					
					case 0:
						operacion=0;
					break;
				
					case 1 :
						num1=(num2-num1);
						System.out.println(num1);
					break;
				
					case 2 :
						System.out.println("Introduce el primer número:");
						num1 = sc.nextDouble();
					break;
					
					default:
						System.out.println("Por favor, introduce 1, 2 o 0.");
						System.out.println();
				}//switch continuar 
				}/*do continuar*/while (continuar>2);}//else resta 
			break;
			
			case 3: 
				System.out.print(num1+" * "+num2+" = ");
				System.out.println(num1*num2);
				System.out.println();
				
				do {
				System.out.println("Introduce 1 para continuar con el resultado anterior.");
				System.out.println("Introduce 2 para empezar desde el principio.");
				System.out.println("Introduce 0 para salir.");
				continuar = sc.nextInt();
				System.out.println();
				
				switch (continuar) {
					
					case 0:
						operacion=0;
					break;
				
					case 1 :
						System.out.println(num1*=num2);
					break;
				
					case 2 :
						System.out.println("Introduce el primer número:");
						num1 = sc.nextDouble();
					break;
					
					default:
						System.out.println("Por favor, introduce 1, 2 o 0.");
						System.out.println();
				}//switch continuar 
				}/*do continuar*/while (continuar>2);
			break;
			
			case 4: 
				if(num2==0) {
				System.out.println();
				System.out.println("Opción incorrecta.");
				System.out.println("El divisor no puede ser 0.");
				System.out.println();
				System.out.println(num1+" / ?");
				System.out.println("Introduce el segundo número:");
				num2 = sc.nextDouble();
				}//if division
				System.out.print(num1+" / "+num2+" = ");
				System.out.println(num1/num2);
				System.out.println();
				
				do {
				System.out.println("Introduce 1 para continuar con el resultado anterior.");
				System.out.println("Introduce 2 para empezar desde el principio.");
				System.out.println("Introduce 0 para salir.");
				continuar = sc.nextInt();
				System.out.println();
				
				switch (continuar) {
					
					case 0:
						operacion=0;
					break;
				
					case 1 :
						System.out.println(num1/=num2);
					break;
				
					case 2 :
						System.out.println("Introduce el primer número:");
						num1 = sc.nextDouble();
					break;
					
					default:
						System.out.println("Por favor, introduce 1, 2 o 0.");
						System.out.println();
				
				}//switch continuar 
				}/*do continuar*/while (continuar>2);
			break;
			
			case 5: 
				if (num2==0) {
				System.out.println();
				System.out.println("Opción incorrecta.");
				System.out.println("El divisor no puede ser 0.");
				System.out.println();
				System.out.println(num1+" % ?");
				System.out.println("Introduce el segundo número:");
				num2 = sc.nextDouble();
				}//if resto 
				System.out.print(num1+" % "+num2+" = ");
				System.out.println(num1%num2);
				System.out.println();
				do {
				System.out.println("Introduce 1 para continuar con el resultado anterior.");
				System.out.println("Introduce 2 para empezar desde el principio.");
				System.out.println("Introduce 0 para salir.");
				continuar = sc.nextInt();
				System.out.println();
				
				switch (continuar) {
					
					case 0:
						operacion=0;
					break;
				
					case 1 :
						System.out.println(num1%=num2);
					break;
				
					case 2 :
						System.out.println("Introduce el primer número:");
						num1 = sc.nextDouble();
					break;
					
					default:
						System.out.println("Por favor, introduce 1, 2 o 0.");
						System.out.println();
				
				}//switch continuar 
				}/*do continuar*/while (continuar>2);
			break;
			}//switch
			}//else op>6
		}/*do1*/ while(operacion!=0);
		System.out.println("Fin.");

	}//main

}//public class
