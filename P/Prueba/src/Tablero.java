import java.time.LocalDate;
import java.util.Scanner;

public class Tablero {

	public static void main(String[] args) {
		String s = "Hola";
		String año = "2024";
		String fecha = "2024-12-05";
		LocalDate fechas = LocalDate.parse(fecha);
		boolean condena=true;	
		
		int prision= prision(condena);
		System.out.println(prision);

		String mes = "025";
		int mes1 = Integer.valueOf(mes);
		System.out.println(mes);
		System.out.println(mes1);
		
		int a = 10 + Integer.valueOf(año) ;
		if (!s.equals("Adios")) {
			System.out.println("Adios");
		}else System.out.println("Hola");
		if (!año.equals(2025))	System.out.println("2024");
		System.out.println(fechas);
		System.out.println(a);
		
		if (mes1<10) mes="0"+mes;
		System.out.println(mes);
		 
		if (isNumeric(s)) {
			System.out.println(año);
		}else	System.out.println(s)  ;
		
		/*
		int x, y, z;
				Scanner sc = new Scanner (System.in);
		
		System.out.println("ancho");
		x = sc.nextInt();
		System.out.println("largo");
		y = sc.nextInt();
		
		int [][] matrix = new int [x][y];
		
		for (int i=0;i<x;i++){
			System.out.println("");
			for (int j=0;j<y;j++) {
				matrix[i][j] = (int) (Math.random()*9+1);
				System.out.print(matrix[i][j]+" ");
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.println("numero");
		z = sc.nextInt();
		
		for (int i=0;i<x;i++){
			for (int j=0;j<y;j++) {
				if (matrix[i][j]==z) {System.out.println("Si");}
				else {System.out.println("No");}
			}
		}
		*/
	}
	private static boolean isNumeric(String str){
        return str != null && str.matches("[0-9.]+");
    }
	
	protected static int prision(boolean condena) {
		int prision;
		if (!condena) {prision=0;}
		else prision = 100;
		return prision;
	}
}
