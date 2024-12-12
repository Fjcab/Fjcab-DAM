package electrodomesticos;

import java.util.ArrayList;
import java.util.Scanner;

public class DarAlta {
	
	public static void darAlta (Scanner sc, ArrayList<Electrodomestico>listaElectro) {
		int opcion;
	do {
		Menus.mostrarMenuAlta();
		opcion = sc.nextInt();
		}while(opcion==0 || opcion>3);
		switch(opcion) {
		case 1:
			darAltaElectro(sc, listaElectro);
			System.out.println();
			break;
		case 2:
			darAltaLavadora(sc, listaElectro);
			System.out.println();
			break;
		case 3:
			darAltaTelevision(sc, listaElectro);
			System.out.println();
		break;
		}
	}
	
	public static void darAltaElectro (Scanner sc, ArrayList<Electrodomestico>listaElectro) {
		int opcion1;
		double precioBase, peso;
		char consumoEnergetico;
		String color;
		do {
		Menus.mostrarMenuElectro();
		opcion1 = sc.nextInt();
		}while (opcion1==0 || opcion1>3);
		switch(opcion1) {
		case 1:
		Electrodomestico e1 = new Electrodomestico();
			listaElectro.add((Electrodomestico)e1);
			break;
		case 2:
			System.out.println("Introduce el precio del electrodoméstico:");
			precioBase = sc.nextDouble();
			System.out.println("Introduce el peso del electrodoméstico:");
			peso = sc.nextDouble();
			e1 = new Electrodomestico(precioBase, peso);
			listaElectro.add((Electrodomestico)e1);
			break;
		case 3:
			System.out.println("Introduce el precio del electrodoméstico:");
			precioBase = sc.nextDouble();
			System.out.println("Introduce el peso del electrodoméstico:");
			peso = sc.nextDouble();
			System.out.println("Introduce el color del electrodoméstico:");
			color = sc.next();
			System.out.println("Introduce el consumo del electrodoméstico:");
			consumoEnergetico = sc.next().toUpperCase().charAt(0);
			e1 = new Electrodomestico(precioBase,peso,color,consumoEnergetico);
			listaElectro.add((Electrodomestico)e1);
		break;
			}
		}
	
	public static void darAltaLavadora (Scanner sc, ArrayList<Electrodomestico>listaElectro) {
		int opcion1, carga;
		double precioBase, peso;
		char consumoEnergetico;
		String color;
		do {
			Menus.mostrarMenuElectro();
			opcion1 = sc.nextInt();
		}while (opcion1==0 || opcion1>3);
		switch(opcion1) {
		case 1:
			Electrodomestico e1 = new Lavadora();
			listaElectro.add((Electrodomestico)e1);
			break;
		case 2:
			System.out.println("Introduce el precio de la lavadora:");
			precioBase = sc.nextDouble();
			System.out.println("Introduce el peso de la lavadora:");
			peso = sc.nextDouble();
			e1 = new Lavadora(precioBase, peso);
			listaElectro.add((Electrodomestico)e1);
			break;
		case 3:
			System.out.println("Introduce el precio de la lavadora:");
			precioBase = sc.nextDouble();
			System.out.println("Introduce el peso de la lavadora:");
			peso = sc.nextDouble();
			System.out.println("Introduce el color de la lavadora:");
			color = sc.next();
			System.out.println("Introduce el consumo de la lavadora:");
			consumoEnergetico = sc.next().toUpperCase().charAt(0);
			System.out.println("Introduce la carga de la lavadora:");
			carga = sc.nextInt();
			e1 = new Lavadora(precioBase,peso,color,consumoEnergetico,carga);
			listaElectro.add((Electrodomestico)e1);
			break;
		}
	}

	public static void darAltaTelevision (Scanner sc, ArrayList<Electrodomestico>listaElectro) {
		int opcion1, opcion2;
		double precioBase, peso, resolucion;
		char consumoEnergetico;
		String color;
		do {
			Menus.mostrarMenuElectro();
			opcion1 = sc.nextInt();
		}while (opcion1==0 || opcion1>3);
		switch(opcion1) {
		case 1:
			Electrodomestico e1 = new Television();
			listaElectro.add((Electrodomestico)e1);
			break;
		case 2:
			System.out.println("Introduce el precio de la televisión:");
			precioBase = sc.nextDouble();
			System.out.println("Introduce el peso de la televisión:");
			peso = sc.nextDouble();
			e1 = new Television(precioBase, peso);
			listaElectro.add((Electrodomestico)e1);
			break;
		case 3:
			boolean sintonizador=false;
			System.out.println("Introduce el precio de la televisión:");
			precioBase = sc.nextDouble();
			System.out.println("Introduce el peso de la televisión:");
			peso = sc.nextDouble();
			System.out.println("Introduce el color de la televisión:");
			color = sc.next();
			System.out.println("Introduce el consumo de la televisión:");
			consumoEnergetico = sc.next().toUpperCase().charAt(0);
			System.out.println("Introduce la resolucion de la televisión:");
			resolucion = sc.nextInt();
			System.out.println("¿Tiene la televisión sintonizador de TDT?:");
			do {
				Menus.mostrarMenuTDT();
				opcion2=sc.nextInt();
			}while (opcion2==0 || opcion2>2);
			if (opcion2==1) sintonizador=true;
			if (opcion2==2) sintonizador=false;
			e1 = new Television(precioBase,peso,color,consumoEnergetico,resolucion,sintonizador);
			listaElectro.add((Electrodomestico)e1);
			break;
		}
	}
	
}
