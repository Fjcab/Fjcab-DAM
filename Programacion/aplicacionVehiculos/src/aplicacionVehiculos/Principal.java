package aplicacionVehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String matricula,dni;
		ArrayList<Vehiculos>coches=new ArrayList<Vehiculos>(); 
		ArrayList<Clientes>cliente=new ArrayList<Clientes>();
		int opcion1, opcion2;

		do {
			mostrarMenu();
			opcion1=sc.nextInt();
			switch (opcion1){
			case 1:			
				do {
					mostrarMenu2();
					opcion2=sc.nextInt();
					switch(opcion2) {
					case 1:
						System.out.println("Introduce la matrícula del vehículo.");
						matricula=sc.next();
						insertarVehiculo(matricula, sc, coches);
						opcion2=3;
						break;
					case 2:
						System.out.println("Introduce el DNI del cliente.");
						dni=sc.next();
						insertarCliente(dni, sc, cliente);
						opcion2=3;
						break;
					case 3:
						break;
					default:
						System.out.println("Introduce 1, 2 o 3.");
						System.out.println();
					}
				}while (opcion2!=3);
				break;				
			case 2:
				do {
					mostrarMenu2();
					opcion2=sc.nextInt();
					switch(opcion2) {
					case 1:
						System.out.println("Introduce la matrícula del vehículo.");
						matricula=sc.next();
						borrarVehiculo(matricula, sc, coches);
						opcion2=3;
						break;
					case 2:
						System.out.println("Introduce el DNI del cliente.");
						dni=sc.next();
						borrarCliente(dni, sc, cliente);
						opcion2=3;
						break;
					case 3:
						break;
					default:
						System.out.println("Introduce 1, 2 o 3.");		
						System.out.println();
					}
				}while (opcion2!=3);
				break;				
			case 3:				
				do {
					mostrarMenu2();
					opcion2=sc.nextInt();
					switch(opcion2) {
					case 1:
						System.out.println("Introduce la matrícula del vehículo.");
						matricula=sc.next();
						modificarVehiculo(matricula, sc, coches);
						opcion2=3;
						break;
					case 2:
						System.out.println("Introduce el DNI del cliente.");
						dni=sc.next();
						modificarCliente(dni, sc, cliente);
						opcion2=3;
						break;
					case 3:
						break;
					default:
						System.out.println("Introduce 1, 2 o 3.");	
						System.out.println();
					}
				}while (opcion2!=3);
				break;				
			case 4:
				System.out.println("Introduce la matrícula del vehículo.");
				matricula = sc.next();
				venta(matricula, sc, coches, cliente);
				break;				
			case 5:
				do {
					mostrarMenu2();
					opcion2=sc.nextInt();
					switch(opcion2) {
					case 1:
						mostrarVehiculos(sc, coches);
						opcion2=3;
						break;
					case 2:
						mostrarClientes(sc, cliente);
						opcion2=3;
						break;
					case 3:
						break;
					default:
						System.out.println("Introduce 1, 2 o 3.");	
						System.out.println();
					}
				}while (opcion2!=3);
				break;				
			case 6:
				break;				
			case 7:
				System.out.println("Fin");
				break;				
			default:
				System.out.println("Introduce un numero del 1 al 6.");
				System.out.println();
			}
		}while(opcion1!=6);
	}

	public static void mostrarMenu() {
		System.out.println("Menú.");
		System.out.println("1.-Insertar.");
		System.out.println("2.-Dar de baja.");
		System.out.println("3.-Modificar.");
		System.out.println("4.-Vender Vehículo.");		
		System.out.println("5.-Mostrar.");			
		System.out.println("6.-Salir.");
		System.out.println();
	}	

	public static void mostrarMenu2() {
		System.out.println("1.-Vehículos.");
		System.out.println("2.-Clientes.");
		System.out.println("3.-Salir.");
		System.out.println();
	}

	public static boolean existeVehiculo(String matricula, ArrayList<Vehiculos>coches) {
		boolean existe=false;
		for (Vehiculos c: coches) {
			if(c.getMatricula().equals(matricula)){
				System.out.println("El vehículo está en el sistema.");
				System.out.println();
				existe=true;
				break;
			}
		}
		return existe;	
	}
	public static boolean existeCliente(String dni, ArrayList<Clientes>cliente) {
		boolean existe=false;
		for (Clientes c: cliente) {
			if(c.getDni().equals(dni)){
				System.out.println("El cliente está en el sistema.");
				System.out.println();
				existe=true;
				break;
			}
		}
		return existe;	
	}

	public static void insertarVehiculo(String matricula, Scanner sc,ArrayList<Vehiculos>coches) {
		if (!existeVehiculo(matricula, coches)) {
			System.out.println("Introduce la marca del vehículo.");
			String marca=sc.next();
			System.out.println("Introduce el modelo del vehículo.");
			String modelo=sc.next();
			System.out.println("Introduce el tipo de motor del vehículo.");
			String motor=sc.next();
			System.out.println("Introduce el color del vehículo.");
			String color=sc.next();
			System.out.println("Introduce el precio del vehículo.");
			double precio=sc.nextDouble();
			System.out.println("Introduce el stock del vehículo.");
			int stock=sc.nextInt();
			Vehiculos v = new Vehiculos(matricula, marca ,modelo ,motor, color, precio, stock);
			coches.add(v);
			System.out.println();
		}
	}

	public static void insertarCliente(String dni, Scanner sc, ArrayList<Clientes>cliente) {
		if (!existeCliente(dni, cliente)) {
			System.out.println("Introduce el nombre del cliente.");
			sc.nextLine();
			String nombre=sc.nextLine();
			System.out.println("Introduce los apellidos del cliente.");
			String apellidos=sc.nextLine();
			System.out.println("Introduce contacto del cliente");
			String contacto=sc.next();
			Clientes c = new Clientes(dni, nombre, apellidos, contacto);
			cliente.add(c);
			System.out.println();
		}
	}

	public static void borrarVehiculo(String matricula, Scanner sc, ArrayList<Vehiculos>coches) {
		for (int i=0; i<coches.size();i++) {
			if (coches.get(i).getMatricula().equals(matricula)) {
				coches.remove(i);
				System.out.println("El vehículo "+matricula+" ha sido eliminado.");
				System.out.println();
			}	
		}
	}

	public static void borrarCliente(String dni, Scanner sc, ArrayList<Clientes>cliente) {
		for (int i=0; i<cliente.size();i++) {
			if (cliente.get(i).getDni().equals(dni)) {
				cliente.remove(i);
				System.out.println("El cliente "+dni+" ha sido eliminado.");
				System.out.println();
			}	
		}
	}

	public static void menuModificarV() {		
		System.out.println("Menú modificar.");
		System.out.println("1.-Modificar matrícula.");
		System.out.println("2.-Modificar marca.");
		System.out.println("3.-Modificar modelo.");
		System.out.println("4.-Modificar motor.");
		System.out.println("5.-Modificar color.");
		System.out.println("6.-Modificar precio.");
		System.out.println("7.-Modificar stock.");
		System.out.println("8.-Salir");
		System.out.println();
	}

	public static void menuModificarC() {
		System.out.println("1.-Modificar DNI.");
		System.out.println("2.-Modificar nombre.");
		System.out.println("3.-Modificar apellidos.");
		System.out.println("4.-Modificar contacto.");
		System.out.println("5.-Modificar comprados.");
		System.out.println("6.-Salir");
		System.out.println();
	}

	public static void modificarVehiculo(String matricula, Scanner sc, ArrayList<Vehiculos>coches) {
		int menu;
		if (existeVehiculo(matricula, coches)) {
			do {
				menuModificarV();
				menu=sc.nextInt();
				switch (menu) {				
				case 1:
					for(Vehiculos c: coches) {
						if(c.getMatricula().equals(matricula)) {
							System.out.println("Introduce la nueva matrícula.");
							matricula=sc.next();
							c.setMatricula(matricula);
							System.out.println("Matrícula modificada.");
							System.out.println();
						}
					}
					break;					
				case 2:
					for(Vehiculos c: coches) {
						if(c.getMatricula().equals(matricula)) {
							System.out.println("Introduce la marca.");
							String marca=sc.next();
							c.setMarca(marca);
							System.out.println("Marca modificada.");
							System.out.println();
						}
					}
					break;					
				case 3:
					for(Vehiculos c: coches) {
						if(c.getMatricula().equals(matricula)) {
							System.out.println("Introduce el modelo.");
							String modelo=sc.next();
							c.setModelo(modelo);
							System.out.println("Modificado el modelo.");
							System.out.println();
						}
					}
					break;					
				case 4:
					for(Vehiculos c: coches) {
						if(c.getMatricula().equals(matricula)) {
							System.out.println("Introduce el motor.");
							String motor=sc.next();
							c.setMotor(motor);
							System.out.println("Motor modificado.");
							System.out.println();
						}
					}
					break;					
				case 5:
					for(Vehiculos c: coches) {
						if(c.getMatricula().equals(matricula)) {
							System.out.println("Introduce el color nuevo.");
							String color=sc.next();
							c.setColor(color);
							System.out.println("Color modificado.");
							System.out.println();
						}
					}
					break;					
				case 6:
					for(Vehiculos c: coches) {
						if(c.getMatricula().equals(matricula)) {
							System.out.println("Introduce el nuevo precio.");
							double precio=sc.nextDouble();
							c.setPrecio(precio);
							System.out.println("Precio modificado.");
							System.out.println();
						}
					}
					break;	
				case 7:
					for(Vehiculos c: coches) {
						if(c.getMatricula().equals(matricula)) {
							System.out.println("Introduce el nuevo stock.");
							int stock=sc.nextInt();
							c.setStock(stock);
							System.out.println("Stock modificado.");
							System.out.println();
						}
					}		
					break;	
				case 8:
					System.out.println("Salir modificar");
					System.out.println();
					break;
				default :
					System.out.println("Introduce un número del 1 al 8.");
					System.out.println();
				}
			}while (menu!=8);
		}
		else {
			System.out.println("El vehículo no se encuentra en el sistema.");
			System.out.println();
		}
	}

	public static void modificarCliente(String dni, Scanner sc, ArrayList<Clientes>cliente) {
		int menu;
		if (existeCliente(dni, cliente)) {
			do {
				menuModificarC();
				menu=sc.nextInt();
				switch (menu) {
				case 1:
					for(Clientes c: cliente) {
						if(c.getDni().equals(dni)) {
							System.out.println("Introduce el nuevo DNI.");
							dni=sc.next();
							if (!existeCliente(dni, cliente)) {
								c.setDni(dni);
								System.out.println("DNI modificado.");
								System.out.println();
							}
						}
					}
					break;
				case 2:
					for(Clientes c: cliente) {
						if(c.getDni().equals(dni)) {
							System.out.println("Introduce el nombre.");
							String nombre=sc.next();
							c.setNombre(nombre);
							System.out.println("Nombre modificado.");
							System.out.println();
						}
					}
					break;
				case 3:
					for(Clientes c: cliente) {
						if(c.getDni().equals(dni)) {
							System.out.println("Introduce los apellidos.");
							String apellidos=sc.next();
							c.setApellidos(apellidos);
							System.out.println("Modificados los apellidos.");
							System.out.println();
						}
					}
					break;
				case 4:
					for(Clientes c: cliente) {
						if(c.getDni().equals(dni)) {
							System.out.println("Introduce el contacto.");
							String contacto=sc.next();
							c.setContacto(contacto);
							System.out.println("Contacto modificado.");
							System.out.println();
						}
					}
					break;
				case 5:
					for(Clientes c: cliente) {
						if(c.getDni().equals(dni)) {
							ArrayList<Vehiculos>listaComprados=new  ArrayList<Vehiculos>();
							c.setListaComprados(listaComprados);
							System.out.println(c.getListaComprados());
							System.out.println();
						}
					}
					break;
				case 6:
					System.out.println("Salir modificar");
					System.out.println();
					break;
				default :
					System.out.println("Introduce un número del 1 al 6.");
					System.out.println();
				}
			}while (menu!=8);
		}else {			
			System.out.println("El cliente no se encuentra en el sistema.");
			System.out.println();
		}
	}

	public static boolean comprobarStock(String matricula, ArrayList<Vehiculos>coches){
		boolean cantidad=false;
		for(Vehiculos c: coches) {
			if (c.getMatricula().equals(matricula)){				
				if (c.getStock()>0) {
					cantidad=true;
					break;
				}
			}
		}
		return cantidad;
	}

	public static void venta(String matricula, Scanner sc, ArrayList<Vehiculos>coches, ArrayList<Clientes>cliente){
		if (existeVehiculo(matricula, coches)){
			if (comprobarStock(matricula, coches)) {
				for(Vehiculos c: coches) {
					if(c.getMatricula().equals(matricula)) {
						System.out.println("Introduce el DNI del cliente:");
						String dni = sc.next();
						if (existeCliente(dni, cliente)) {
							for (Clientes cl: cliente) {
								cl.getListaComprados().add(c);
								c.setStock(c.getStock()-1);
								System.out.println("Venta completada.");
								System.out.println();
								break;
							}
						}
						else {
							insertarCliente(dni, sc, cliente);
							for (Clientes cl: cliente) {
								cl.getListaComprados().add(c);
								c.setStock(c.getStock()-1);
								System.out.println("Venta completada.");
								System.out.println();
								break;
							}
						}
					}
				}
			}
			else {
				System.out.println("No hay stock.");
				System.out.println();
			}
		}else {
			System.out.println("El vehículo no está en el sistema.");
			System.out.println();
		}
	}

	public static void mostrarMenuV() {
		System.out.println("Menú mostrar vehículos.");
		System.out.println("1.-Todos.");
		System.out.println("2.-Disponibles.");
		System.out.println("3.-No disponibles.");
		System.out.println("4.-Salir");
		System.out.println();
	}
	public static void mostrarMenuC() {
		System.out.println("Menú mostrar clientes.");
		System.out.println("1.-Todos.");
		System.out.println("2.-Todos los vehiculos comprados.");
		System.out.println("3.-Vehiculos comprados por un cliente.");
		System.out.println("4.-Salir");
		System.out.println();
	}

	public static void mostrarVehiculos(Scanner sc, ArrayList<Vehiculos>coches) {
		int opcion;
		do {
			mostrarMenuV();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				for(Vehiculos c: coches) {	
					System.out.print("Vehículo: "); 
					System.out.print(c.getMatricula()+" | ");
					System.out.print(c.getMarca()+" | ");
					System.out.print(c.getModelo()+" | ");
					System.out.print(c.getMotor()+" | ");
					System.out.print(c.getColor()+" | ");
					System.out.print(c.getPrecio()+" | ");
					System.out.print(c.getStock()+".");
					System.out.println();
				}
				System.out.println();
				break;
			case 2:
				for(Vehiculos c: coches) {	
					if (c.getStock()>0) {
						System.out.print("Vehículo: "); 
						System.out.print(c.getMatricula()+" | ");
						System.out.print(c.getMarca()+" | ");
						System.out.print(c.getModelo()+" | ");
						System.out.print(c.getMotor()+" | ");
						System.out.print(c.getColor()+" | ");
						System.out.print(c.getPrecio()+" | ");
						System.out.print(c.getStock()+".");
						System.out.println();
					}
				}
				System.out.println();
				break;
			case 3:
				for(Vehiculos c: coches) {	
					if (c.getStock()==0) {
						System.out.print("Vehículo: "); 
						System.out.print(c.getMatricula()+" | ");
						System.out.print(c.getMarca()+" | ");
						System.out.print(c.getModelo()+" | ");
						System.out.print(c.getMotor()+" | ");
						System.out.print(c.getColor()+" | ");
						System.out.print(c.getPrecio()+" | ");
						System.out.print(c.getStock()+".");
						System.out.println();
					}
				}
				System.out.println();
				break;
			case 4:
				break;
			default:
				System.out.println("Introduce un número del 1 al 4.");	
				System.out.println();
			}
		}while (opcion!=4);
	}

	public static void mostrarClientes(Scanner sc, ArrayList<Clientes>cliente) {
		int opcion;
		do {
			mostrarMenuC();
			opcion=sc.nextInt();
			switch(opcion) {
			case 1:
				for(Clientes c: cliente) {	
					System.out.println("Cliente: "); 
					System.out.print(c.getDni()+" | ");
					System.out.print(c.getNombre()+" | ");
					System.out.print(c.getApellidos()+" | ");
					System.out.print(c.getContacto()+" | ");
					System.out.println();
				}
				break;
			case 2:
				for(Clientes c: cliente) {	
					if (c.getListaComprados()!=null) {
						System.out.println("El cliente "+c.getDni()+" "+c.getNombre()+" "+c.getApellidos()+":");
						System.out.println(c.getListaComprados().toString());
						System.out.println();
					}
				}
				break;
			case 3:
				System.out.println("Introduce el DNI del cliente:");
				String dni=sc.next();
				for(Clientes c: cliente) {	
					if (c.getDni().equalsIgnoreCase(dni)) {
						if (c.getListaComprados()!=null) {
							System.out.println("El cliente "+c.getDni()+" "+c.getNombre()+" "+c.getApellidos()+":");
							System.out.println(c.getListaComprados().toString());
							System.out.println();
							break;
						}else {
							System.out.println("El cliente no ha comprado ningún vehículo.");
						}
					}
				}
				break;
			case 4:
				break;
			default:
				System.out.println("Introduce un número del 1 al 4.");	
				System.out.println();
			}
		}while (opcion!=4);
	}
}
