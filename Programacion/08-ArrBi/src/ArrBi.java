
public class ArrBi {

	public static void main(String[] args) {
		
		final int FILAS=10;
		final int COLUMNAS=20;
		String arrayBi [][] = new String [FILAS][COLUMNAS];
		
		int enteros [] = new int [3];
		System.out.println(enteros[2]);
		
		arrayBi [0][3]="Javier";
		System.out.println(arrayBi[0][3]);
		System.out.println(arrayBi[0][0]);
		
		/*if(arrayBi[0][0].equals("Javier")){
		}ERROR*/
		if(arrayBi[0][0]!=null && arrayBi[0][0].equals("Javier")){
		}
		

	}

}
