import java.util.Scanner;

public class Vehiculos {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int opcion, modificar;
		final int FILAS = 10;
		final int COLUMNAS = 5;
		String matricula;
		boolean vehiculo = false;
		String vehiculos[][] = new String[FILAS][COLUMNAS];

		do {
			System.out.println("Menu:");
			System.out.println("1-Dar de alta un vehículo");
			System.out.println("2-Dar de baja un vehículo");
			System.out.println("3-Modificar datos de un vehículo");
			System.out.println("4-Mostrar datos de un vehículo");
			System.out.println("5-Mostrar todo");
			System.out.println("6-Salir");
			opcion = sc.nextInt();
			System.out.println();
			switch (opcion) {
			case 1:
				System.out.println("Dime la matricula");
				matricula = sc.next();

				for (int i = 0; i < vehiculos.length; i++) {
					if (vehiculos[i][0] != null && vehiculos[i][0].equals(matricula)) {
						System.out.println("El vehículo ya está guardado. No se puede insertar.");
						System.out.println();
						vehiculo = true;
						break;
					}
				}
				if (!vehiculo) {
					for (int i = 0; i < vehiculos.length; i++) {
						if (vehiculos[i][0] == null) {
							vehiculos[i][0] = matricula;
							System.out.println("Dime la marca");
							vehiculos[i][1] = sc.next();
							System.out.println("Dime la modelo");
							vehiculos[i][2] = sc.next();
							System.out.println("Dime el color");
							vehiculos[i][3] = sc.next();
							System.out.println("Dime el motor");
							vehiculos[i][4] = sc.next();
							System.out.println();
							i = vehiculos.length;
						}
					}
				}
				vehiculo = false;
				break;
			case 2:
				System.out.println("Dime la matricula");
				matricula = sc.next();
				for (int i = 0; i < vehiculos.length; i++) {
					if (vehiculos[i][0] != null && vehiculos[i][0].equals(matricula)) {
						vehiculos[i][0] = null;
						System.out.println("Vehiculo eliminado.");
						System.out.println();
					}
				}
				break;
			case 3:
				System.out.println("Dime la matricula");
				matricula = sc.next();
				System.out.println();
				for (int i = 0; i < vehiculos.length; i++) {
					if (vehiculos[i][0] != null && vehiculos[i][0].equals(matricula)) {
						do {
						System.out.println("1.Modificar la matricula");
						System.out.println("2.Modificar la marca");
						System.out.println("3.Modificar el modelo");
						System.out.println("4.Modificar el color");
						System.out.println("5.Modificar el motor");
						System.out.println("6.Modificar todo");
						System.out.println("7.Salir");
						modificar = sc.nextInt();
						switch(modificar) {
						
						case 1:							
							System.out.println("Dime la matricula nueva:");
							vehiculos[i][0] = sc.next();
							System.out.println("Matricula modificada.");
							System.out.println();
							break;
						case 2:
							System.out.println("Dime la marca:");
							vehiculos[i][1] = sc.next();
							System.out.println("Marca modificada.");
							System.out.println();
							break;
						case 3:
							System.out.println("Dime el modelo:");
							vehiculos[i][2] = sc.next();
							System.out.println("Modelo modificado.");
							System.out.println();
							break;
						case 4:
							System.out.println("Dime el color:");
							vehiculos[i][3] = sc.next();
							System.out.println("Color modificado.");
							System.out.println();
							break;
						case 5:
							System.out.println("Dime el motor:");
							vehiculos[i][4] = sc.next();
							System.out.println("Motor modificado.");
							System.out.println();
							break;
						case 6:
							System.out.println("Dime la matricula nueva:");
							vehiculos[i][0] = sc.next();
							System.out.println("Matricula modificada.");
							System.out.println("Dime la marca:");
							vehiculos[i][1] = sc.next();
							System.out.println("Marca modificada.");
							System.out.println("Dime el modelo:");
							vehiculos[i][2] = sc.next();
							System.out.println("Modelo modificado.");
							System.out.println("Dime el color:");
							vehiculos[i][3] = sc.next();
							System.out.println("Color modificado.");
							System.out.println("Dime el motor:");
							vehiculos[i][4] = sc.next();
							System.out.println("Motor modificado.");
							System.out.println();
							modificar=7;
							break;
						case 7:
							System.out.println();
							break;
						default:
							System.out.println("Introduce un numero entre 1 y 7.");
							System.out.println();
						}
						}while(modificar!=7);
					}
				}
				break;
			case 4:
				System.out.println("Dime la matricula.");
				matricula=sc.next();
				for (int i=0;i<vehiculos.length;i++) {
					if (vehiculos[i][0]!=null && vehiculos[i][0].equals(matricula)){
						System.out.print(vehiculos[i][0]);
						System.out.print(" ");
						System.out.print(vehiculos[i][1]);
						System.out.print(" ");
						System.out.print(vehiculos[i][2]);
						System.out.print(" ");
						System.out.print(vehiculos[i][3]);
						System.out.print(" ");
						System.out.println(vehiculos[i][4]);
						System.out.println();
						i=vehiculos.length;
					}
				}
				break;
			case 5:
				for (int i=0;i<vehiculos.length;i++){
					System.out.print(vehiculos[i][0]);
					System.out.print(" ");
					System.out.print(vehiculos[i][1]);
					System.out.print(" ");
					System.out.print(vehiculos[i][2]);
					System.out.print(" ");
					System.out.print(vehiculos[i][3]);
					System.out.print(" ");
					System.out.println(vehiculos[i][4]);
					System.out.println();
				}
				break;
			case 6:
				System.out.println("Fin");
				break;
			default:
				System.out.println("Opcion Incorrecta");
				System.out.println();
			}
		} while (opcion!=6);
	}

}
