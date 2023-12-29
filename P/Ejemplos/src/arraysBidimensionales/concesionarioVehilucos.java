package arraysBidimensionales;

import java.util.Scanner;

public class concesionarioVehilucos {

	public static void main(String[] args) {
		int opcion;
		final int FILAS=100;
		final int COLUMNAS=5;
		String matricula;
		boolean vehiculo=false;
		Scanner sc = new Scanner(System.in);
		String vehiculos [][] = new String [FILAS][COLUMNAS];
		
		do {
			System.out.println("Menu de opciones");
			System.out.println("1.- Dar de alta un vehículo");
			System.out.println("2.- Dar de baja un vehículo");
			System.out.println("3.- Modificar datos de un vehículo");
			System.out.println("4.- Mostrar datos de un vehiculo");
			System.out.println("5.- Salir");
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: System.out.println("Dime la matricula");
						matricula=sc.next();
						//Buscamos la matricula en el array
						for (int filas=0;filas<FILAS;filas++) {
							if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
								System.out.println("No se puede insertar, ya está guardado el vehículo");
								vehiculo=true;//En caso de encontrarlo
								break;
							}
						}
						//Preguntamos si existe o no dicho vehículo
						if(!vehiculo) {
							for (int filas=0;filas<FILAS;filas++) {
								if(vehiculos[filas][0]==null) {
									vehiculos[filas][0]=matricula;
									System.out.println("Dime la marca");
									vehiculos[filas][1]=sc.next();
									System.out.println("Dime el modelo");
									vehiculos[filas][2]=sc.next();
									System.out.println("Dime la color");
									vehiculos[filas][3]=sc.next();
									System.out.println("Dime el motor");
									vehiculos[filas][4]=sc.next();
									filas=FILAS;
								}
							}
						}
						vehiculo=false;
					break;
				case 2: System.out.println("Dime la matricula");
						matricula=sc.next();
						//Buscamos la matricula en el array
						for (int filas=0;filas<FILAS;filas++) {
							if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
								vehiculos[filas][0]=null;
								System.out.println("Vehiculo eliminado");
								break;
							}
						}
					break;
				case 3: System.out.println("Dime la matricula");
						matricula=sc.next();
						//Buscamos la matricula en el array
						for (int filas=0;filas<FILAS;filas++) {
							if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
								System.out.println("Dime la matricula nueva");
								vehiculos[filas][0]=sc.next();
								System.out.println("Matricula modificada");
								break;
							}
						}
					break;
				case 4: System.out.println("Dime la matricula");
						matricula=sc.next();
						//Buscamos la matricula en el array
						for (int filas=0;filas<FILAS;filas++) {
							if(vehiculos[filas][0]!=null && vehiculos[filas][0].equals(matricula)) {
								System.out.println("Matricula: "+vehiculos[filas][0]);
								System.out.println("Marca: "+vehiculos[filas][1]);
								System.out.println("Modelo: "+vehiculos[filas][2]);
								System.out.println("Color: "+vehiculos[filas][3]);
								System.out.println("Motor: "+vehiculos[filas][4]);
								break;
							}
						}
			break;	
				case 5: System.out.print("Hasta pronto");
					break;
				default: System.out.print("Opcion incorrecta");
			}
		} while(opcion!=4);
		
	}

}
