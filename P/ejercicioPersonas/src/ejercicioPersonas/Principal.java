package ejercicioPersonas;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre, dni, apellidos;
		int opcion;
		
		Persona p;
		Persona arrayPer [] = new Persona[20];
		
		do {
			System.out.println("1.- Dar de alta a personas");
			System.out.println("2.- Mostrar nombre de una persona");
			System.out.println("3.- Modificar datos personales a personas");
			System.out.println("4.- Dar de alta a personas");
			System.out.println("5.- Salir");
			opcion=sc.nextInt();
			switch(opcion) {
				case 1: System.out.println("Dime tu dni: ");
						dni=sc.next();
						System.out.println("Dime tu nombre: ");
						nombre=sc.next();
						p=new Persona(dni,nombre);
						//nombreArrayList.add(p);
						//arrayPer[0]=p;
						//System.out.println("Su dni es: "+arrayPer[0].getDni());
						/*for(int i=0;i<arrayPer.length;i++) {
							if(arrayPer[i]==null) {
								arrayPer[i]=p;
								break;
							}
						}*/
					break;
				case 2: System.out.println("Dime tu dni: ");
						dni=sc.next();
						for(int i=0;i<arrayPer.length;i++) {
							if(arrayPer[i]!=null && arrayPer[i].getDni().equals(dni)) {
								System.out.println("Nombre: "+arrayPer[i].getNombre());
								break;
							}
						}
					break;
			}
		}while (opcion!=5);

	}

}

