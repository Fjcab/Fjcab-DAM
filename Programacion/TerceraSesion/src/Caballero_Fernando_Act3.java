import java.util.Scanner;

public class Caballero_Fernando_Act3 {

	public static void main(String[] args) {
		
		int figura; 
		double perimetro, area, valor1, valor2, valor3, valor4;
		Scanner sc = new Scanner(System.in);
		/*"figura" lo utilizaremos para seleccionar el tipo de figura según el valor que introduzca el usuario. Tiene que ser un numero entero.
		* "perimetro" y "area" seran los valores finales.
		* "valor1", "valor2", "valor3" y "valor4" seran los valores que introduzca el usuario.
		* Creamos el Scanner, "sc", para que el usuario pueda introducir los datos necesarios.
		*/
		
		do {//Abrimos el bucle con el que el usuario decidira al fimal si quiere volver a empezar.
		//Creamos el menú de selección para el usuario. 
		System.out.println("Selecciona el tipo de figura:");
		System.out.println("Introduce 1 si es un Círculo.");
		System.out.println("Introduce 2 si es un Triángulo.");
		System.out.println("Introduce 3 si es un Cuadrado.");//Cuadrado y Rectángulo podrían seleccionarse juntos pero el enunciado indica que se diferencien.
		System.out.println("Introduce 4 si es un Rectángulo.");
		System.out.println("Introduce 5 para Salir");
		figura = sc.nextInt();
		//En este punto el usuario introduce el valor de "figura"
		
		
		/*Con el "switch" según el valor introducido "1", "2", "3", "4" o "5" seguiremos en el caso correspondiente, 
		 "case 1", "case 2", "case 3", "case 4", case "5" respectivamente.
		 * Introducir otro valor diferente correspondera al caso "default".
		 * En cada caso se pediran al usuario que introduzca los valores necesarios.
		 * Estos valores a continuación se utilizarán para resolver las formulas y obtener el perímetro y el área.
		 * Por último se mostrará  el resultado.
		 */
		switch(figura) {
			case 1:
				System.out.println("Introduce el valor del radio del círculo:");
				valor1 = sc.nextDouble();
				perimetro=2*Math.PI*valor1; //Math.PI= valor de π.
				area=Math.PI*(valor1*valor1);
				System.out.println("El perímetro es "+perimetro+" el área es "+area+".");
				System.out.println("");
			break;//Con break se rompe el switch para que no se ejecuten los siguientes casos.
						
			case 2: //En este caso no diferenciamos en el tipo de triángulo (rectángulo, isosceles, escaleno).
				System.out.println("Introduce el valor de la base del triángulo:");
				valor1 = sc.nextDouble();
				System.out.println("Introduce el valor del lado izquierdo del triángulo:");
				valor2 = sc.nextDouble();
				System.out.println("Introduce el valor del lado derecho del triángulo:");
				valor3 = sc.nextDouble();
				System.out.println("Introduce el valor de la altura del triángulo:");
				valor4 = sc.nextDouble();
				perimetro=valor1+valor2+valor3;
				area=(valor1*valor4)/2;
				System.out.println("El perímetro es "+perimetro+", el área es "+area+".");
				System.out.println("");
			break;
			
			case 3:
				System.out.println("Introduce el valor de uno de los lados del cuadrado:");
				valor1 = sc.nextDouble();
				perimetro=valor1*4;
				area=valor1*valor1;
				System.out.println("El perímetro es "+perimetro+" el área es "+area+".");
				System.out.println("");
			break;
			
			case 4:
				System.out.println("Introduce el valor del ancho del rectángulo:");
				valor1 = sc.nextDouble();
				System.out.println("Introduce el valor del largo del rectángulo:");
				valor2 = sc.nextDouble();
				perimetro=(valor1*2)+(valor2*2);
				area=valor1*valor2;
				System.out.println("El perímetro es "+perimetro+" el área es "+area+".");
				System.out.println("");
			break;
			
			case 5:System.out.println("Fin");
			break;
				
			default:
				System.out.println("Valor equivocado. Por favor empieza de nuevo.");
				System.out.println("");
				}
			//El bucle continúa mientras el valor de "figura" sea distinto a 5.
			}while(figura!=5);
		}
}
