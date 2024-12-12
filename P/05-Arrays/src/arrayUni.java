import java.util.Scanner;

public class arrayUni {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int Array [] = new int [6];
		double Array1 [] = new double [6];
		String Array2 [] = new String [5];
		
		Array [0]=8;
		Array1 [1]=1.5;
		Array2 [1]= ("hola");
		System.out.println("El contenido en la posición 0 es: "+Array[0]);
		System.out.println("El contenido en la posición 0 es: "+Array[1]);
		System.out.println("El contenido en la posición 0 es: "+Array1[0]);
		System.out.println("El contenido en la posición 0 es: "+Array1[1]);
		System.out.println("El contenido en la posición 0 es: "+Array2[0]);
		System.out.println("El contenido en la posición 0 es: "+Array2[1]);
		
		//Creación y asignación de espacio en el array.
		int nombreArray [] =new int [6];
		
		//Guardar información en el array
		for(int i=0;i<nombreArray.length;i++) {
			System.out.print("Dime un número: ");
			nombreArray[i]=sc.nextInt();
		}
		
		//Recorrer el array y mostrar el contenido en cada posición
		for(int i=0;i<nombreArray.length;i++) {
			if (nombreArray[i]==5) {
				System.out.println();
				System.out.println("Encontrado en la posición "+i);
				System.out.println();
			}
			System.out.println("Contenido en la posición "+i+" : "+nombreArray[i]);
		}
		System.out.println();
		System.out.println("El contenido en la posición 4 es: "+nombreArray[4]);
		System.out.println();
	}

}
