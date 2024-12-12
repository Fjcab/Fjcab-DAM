import java.util.Scanner;

public class Tablets {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int menu;
		final int FILA=10, COLUMNA=2;
		String tablet, cliente;
		String tablets [][]= new String [FILA][COLUMNA];
		boolean rep = false;
		do {
		System.out.println("1. Dar de alta una tablet");
		System.out.println("2. Dar de alta un cliente");
		System.out.println("3. Vender una tablet a un cliente");
		System.out.println("4. Mostrar tablets disponibles para la venta");
		System.out.println("5. Mostrar tablet comprada por un cliente en concreto");
		System.out.println("6. Salir");
		menu = sc.nextInt();
		System.out.println();
		switch (menu) {
		case 1:
			System.out.println("Introduce la tablet:");
			tablet = sc.next();
			for (int i=0;i<tablets.length;i++) {
				if (tablets [i][0]!=null && tablets [i][0].equals(tablet)) {
					System.out.println("Eror. La tablet ya ha sido introducida.");
					rep=true;
					i=tablets.length;
				}
			}
			if (!rep) {
				for (int i=0;i<tablets.length;i++) {
					if (tablets [i][0]==null && tablets [i][1]==null) {
						tablets [i][0] = tablet;
						i=tablets.length;
					}
					
				}
			}
			rep=false;
			System.out.println();
			break;
		case 2:
			System.out.println("Introduce el nombre del cliente:");
			cliente = sc.next();
			for (int i=0;i<tablets.length;i++) {
				if (tablets [i][0]!=null) {
					if (tablets [i][1]!=null && tablets [i][1].equals(cliente)) {
					System.out.println("Eror. El cliente ya ha sido introducido.");
					rep=true;
					i=tablets.length;
					}
				}
			}
			if (!rep) {
				for (int i=0;i<tablets.length;i++) {
					if (tablets [i][0]==null && tablets[i][1]==null) {
						tablets [i][1] = cliente;
						i=tablets.length;
					}
					
				}
			}
			rep=false;
			System.out.println();
			break;

		case 3:
			System.out.println("Introduce la tablet:");
			tablet = sc.next();
			System.out.println("Introduce el nombre del cliente:");
			cliente = sc.next();
			for (int i=0;i<tablets.length;i++) {
				if (tablets [i][0]!=null | tablets [i][0].equals(tablet)) {
					if (tablets [i][1]==null) {
						tablets [i][1]= cliente;	
					}
					else {
						System.out.println("Eror. La tablet ya ha sido vendida a el cliente "+tablets [i][1]+".");			
						i=tablets.length;
					}
				}
				else {
					System.out.println("Eror. La tablet no se encuentra en el sistema.");
					i=tablets.length;
					}
			}

			System.out.println();
			break;

		case 4:
			for (int i=0;i<tablets.length;i++) {
				if (tablets [i][0]!=null && tablets [i][1]==null) {
					System.out.println(tablets[i][0]);
				}
			}
			System.out.println();
			break;
		
		case 5:
			System.out.println("Introduce el nombre del cliente:");
			cliente = sc.next();
			for (int i=0;i<tablets.length;i++) {
				if (tablets [i][1]!=null && tablets [i][1].equals(cliente)) {
					System.out.println(tablets[i][0]);
					i=tablets.length;
				}
			}
			System.out.println();
			break;
		case 6:
			System.out.println("Fin");
			break;
		default:
			System.out.println("Error, introduce un numero entre 1 y 6");
			for (int i=0;i<tablets.length;i++) {
				for (int j=0;j<tablets[i].length;j++) {
					System.out.print(tablets[i][j]+"|");
				}
				System.out.println();
				}
			}
		}while (menu!=6);
	}

}
