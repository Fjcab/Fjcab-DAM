import java.util.Scanner;

public class matriculas {
	public static void main(String[] args) {
		
		final int COLUMNAS = 9;
		final int FILAS = 100;
		int opcion;
		boolean encontrado=false;
		String alumno [][] = new String [FILAS][COLUMNAS];
		String dni, nombre, apellidos;
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("1.- Insertar un alumno");
		System.out.println("2.- Dar de baja un alumno");
		System.out.println("3.- Mostrar las notas de un alumno");
		System.out.println("4.- Salir");
		opcion=sc.nextInt();
		switch(opcion) {
		case 1: 
				System.out.println("Dime tu DNI: ");
				dni=sc.next();
			for (int i=0;i<FILAS;i++) {
				if(alumno[i][0]!=null && alumno[i][0].equals(dni)) {
					System.out.println("Alumno ya insertado.");
					encontrado=true;
					i=FILAS;
			}
		}
			if(!encontrado) {
				for (int i=0;i<FILAS;i++) {
					if(alumno[i][0]==null) {
						alumno[i][0]=dni;
						System.out.println("Dime tu nombre: ");
						sc.nextLine();
						alumno[i][1]=sc.nextLine();
						System.out.println("Dime tus apellidos: ");
						alumno[i][2]=sc.nextLine();
						System.out.println("Alumno insertado correctamente.");
						i=FILAS;
						}
					}
				}
			encontrado=false;
			break;
		case 2:
			System.out.println("Dime tu DNI: ");
			dni=sc.next();
			for (int i=0;i<FILAS;i++) {
				if(alumno[i][0]!=null && alumno[i][0].equals(dni)) {
					alumno[i][0]=null;
					alumno[i][1]=null;
					alumno[i][2]=null;
					i=FILAS;
					}
				}
			System.out.println("Alumno eliminado.");
			break;
		case 3:
			System.out.println("Dime tu DNI: ");
			dni=sc.next();
			for (int i=0;i<FILAS;i++) {
				if(alumno[i][0]!=null && alumno[i][0].equals(dni)) {
					System.out.println(alumno[i][3]);
					i=FILAS;
					}
				}
			break;
			}
		}while(opcion!=4);
	}
}
