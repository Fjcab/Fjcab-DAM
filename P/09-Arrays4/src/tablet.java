import java.util.Scanner;

public class tablet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu;
		final int FILA=10, COLUMNA=6, COLUMNA1=4, COLUMNA2=3;
		String tablet, cliente;
		String tablets[][] = new String [FILA][COLUMNA];
		String clientes[][] = new String [FILA][COLUMNA1];
		String ventas[][] = new String [FILA][COLUMNA2];
		
		boolean rep=false, rep2=false;
		do {
		System.out.println("1. Dar de alta una tablet");
		System.out.println("2. Dar de alta un cliente");
		System.out.println("3. Vender una tablet a un cliente");
		System.out.println("4. Mostrar tablets disponibles para la venta");
		System.out.println("5. Mostrar tablet comprada por un cliente en concreto");
		System.out.println("6. Salir");
		menu=sc.nextInt();
		System.out.println();
		switch (menu) {
		case 1:
			System.out.println("Dime el codigo de serie de la tablet:");
			tablet=sc.next();

		for (int i=0;i<tablets.length;i++) {
			if (tablets[i][0]!=null && tablets[i][0].equals(tablet)) {
				System.out.println("La tablet ya está guardada. No se puede insertar.");
				rep=true;
				break;
			}
		}
		if (!rep) {
			for (int i=0;i<tablets.length;i++) {
				if (tablets[i][0]==null) {
					tablets[i][0]=tablet;
					System.out.println("Marca:");
					tablets[i][1]=sc.next();
					System.out.println("Modelo:");
					tablets[i][2]=sc.next();
					System.out.println("Color:");
					tablets[i][3]=sc.next();
					System.out.println("Precio:");
					tablets[i][4]=sc.next();
					tablets[i][5]=("No");					
					i=tablets.length;
				}
			}
		}
		rep=false;
		System.out.println();
		break;
		case 2:
			System.out.println("Dime el DNI del cliente:");
			cliente=sc.next();
			
			for (int i=0;i<clientes.length;i++) {
				if (clientes[i][0]!=null && clientes[i][0].equals(cliente)) {
					System.out.println("El cliente ya está guardado. No se puede insertar.");
					rep=true;
					i=clientes.length;
				}
			}
			if (!rep) {
				for (int i=0;i<clientes.length;i++) {
					if (clientes[i][0]==null) {
						clientes[i][0]=cliente;
						System.out.println("Nombre:");
						clientes[i][1]=sc.next();
						System.out.println("Apellidos:");
						clientes[i][2]=sc.next();
						System.out.println("Contacto:");
						clientes[i][3]=sc.next();
						i=clientes.length;
					}
				}
			}
			rep=false;
			System.out.println();
			break;
		case 3:
			System.out.println("Dime el codigo de serie de la tablet: ");
			tablet=sc.next();
			for (int i=0;i<tablets.length;i++) {
				if (tablets[i][0]!=null && tablets[i][0].equals(tablet)) {
					if (tablets[i][5].equals("Si")) {
						System.out.println("Error. La tablet ya ha sido vendida.");
						i=tablets.length;
					}
					else {
						tablets[i][5]=("Si"); 
						i=tablets.length;
					System.out.println("Dime el DNI del cliente: ");
					cliente=sc.next();
					
					for (i=0;i<clientes.length;i++) {
						if (clientes[i][0]!=null && clientes[i][0].equals(cliente)) {
							rep=true;
							for (i=0;i<ventas.length;i++) {
								if (ventas[i][0]==null) {
									ventas[i][0]=tablet;
									ventas[i][1]=cliente;
									System.out.println("Introduce la forma de pago.");
									ventas[i][2]=sc.next();
									i=ventas.length;
								}
							}
						}
					}
						if(!rep) {
							for (i=0;i<clientes.length;i++) {
								if (clientes[i][0]==null) {
									clientes[i][0]=cliente;
									System.out.println("Nombre:");
									clientes[i][1]=sc.next();
									System.out.println("Apellidos:");
									clientes[i][2]=sc.next();
									System.out.println("Contacto:");
									clientes[i][3]=sc.next();
									i=clientes.length;
								}
							}
								for (i=0;i<ventas.length;i++) {
									if (ventas[i][0]==null) {
										ventas[i][0]=tablet;
										ventas[i][1]=cliente;
										System.out.println("Introduce la forma de pago.");
										ventas[i][2]=sc.next();
										i=ventas.length;
								}					
							}
						}
					}
					rep2=true;
				}
			}
				if (!rep2) {
					System.out.println("Error. La tablet no se encuentra en el sistema.");					
			}
			rep=false;
			rep2=false;
			System.out.println();
			break;
		case 4:
			for (int i=0;i<tablets.length;i++) {
				if (tablets[i][0]!=null && tablets[i][5].equals("No")) {
					System.out.print(tablets[i][0]);
					System.out.print(" ");
					System.out.print(tablets[i][1]);
					System.out.print(" ");
					System.out.print(tablets[i][2]);
					System.out.print(" ");
					System.out.print(tablets[i][3]);
					System.out.print(" ");
					System.out.println(tablets[i][4]);
					rep=true;
					}
				}
			if(!rep){
				System.out.println("No hay ninguna tablet disponible.");				
			}
			rep=false;
			System.out.println();
			break;
		case 5:
			System.out.println("Dime el DNI del cliente: ");
			cliente= sc.next();
			
			for (int i=0;i<ventas.length;i++) {
				if (ventas[i][1]!=null && ventas[i][1].equals(cliente)) {
					if (ventas [i][0]!=null) {
						System.out.print(ventas[i][0]);
						System.out.println();
					}
					rep=true;
					}
				}
			if(!rep){
				for (int i=0;i<clientes.length;i++) {
					if (clientes[i][0]!=null && clientes[i][0].equals(cliente)) {
						System.out.println("El cliente no ha comprado ninguna tablet.");
						rep2=true;
						i=clientes.length;
					}
				}
				if(!rep2) {
					System.out.println("El cliente no está en el sistema.");
				}
			}
			rep=false;
			rep2=false;
			System.out.println();
			break;
		case 6:
			System.out.println("Fin.");
			break;
		default:
			System.out.println("Error. Introduce un numero entre 1 y 6");
			System.out.println();
			}
		}while(menu!=6);
	}

}
