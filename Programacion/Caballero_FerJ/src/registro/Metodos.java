package registro;

import java.util.ArrayList;
import java.util.Scanner;

public class Metodos {


	public static void mostrarMenu(){
		System.out.println("Menú:");
		System.out.println("1.-Dar de alta a un programador.");
		System.out.println("2.-Dar de baja a un programador.");
		System.out.println("3.-Aumentar salario de un programador.");
		System.out.println("4.-Mostrar lista de empleados.");
		System.out.println("5.-Salir");
	}
	
	public static boolean progExiste(String dni, Scanner sc, ArrayList <Empleado> prog) {
		boolean existe = false;
		for(Empleado p: prog) {
			if (p.getDni().equals(dni)) {
				existe=true;
				break;
			}
		}
		
		return existe;
	}
	
	public static void darAlta(String dni, Scanner sc, ArrayList <Empleado> prog) {
		int opcion1;
		String nombre, lenguajeDominante;
		int edad, lineasDeCodigoPorHora;
		boolean casado=false;
		double salario;
		if (!progExiste(dni ,sc, prog)){
			sc.nextLine();
			System.out.println("Introduce el nombre y los apellidos del programador.");
			nombre = sc.nextLine();
			do {
			System.out.println("Introduce la edad del programador.");
			edad = sc.nextInt();
			if (edad<18 | edad>45) {
				System.out.println("El empleado debe tener entre 18 y 45 años.");
			}
			}while (edad<18 | edad>45);
			do {

				System.out.println("¿Esta casado el programador?.");
				System.out.println("1.-Si.");
				System.out.println("2.-No.");
				opcion1=sc.nextInt();
				switch (opcion1) {
				case 1:
					casado=true;
					break;
				case 2:
					casado=false;
					break;
				default:
					System.out.println("Introduce un 1 o un 2.");
				}
			}while (opcion1!=1 & opcion1!=2);
			System.out.println("Introduce el salario del programador.");
			salario= sc.nextDouble();
			System.out.println("Introduce las lineas de codigo por hora del programador.");
			lineasDeCodigoPorHora = sc.nextInt();
			System.out.println("Introduce el lenguaje dominante del programador.");
			lenguajeDominante = sc.next();
			Empleado p = new Programador(dni,nombre ,edad, casado, salario,lineasDeCodigoPorHora,lenguajeDominante);
			prog.add(p);
			System.out.println();
		}
		else {
			System.out.println("El empleado ya esiste.");
			System.out.println();
		}
	}
	
	public static void darBaja(String dni, Scanner sc, ArrayList <Empleado> prog) {
		if (progExiste(dni ,sc, prog)) {
			for (int i=0; i<prog.size();i++) {
				if (prog.get(i).getDni().equals(dni)) {
					prog.remove(i);
					System.out.println("Empleado eliminado.");
					System.out.println();
				}	
			}
		}
		else {
			System.out.println("El empleado no existe.");
			System.out.println();
		}
	}
	
	public static void aumentarSalario(String dni, Scanner sc, ArrayList <Empleado> prog ) {
		Double porcentaje;
		if(progExiste(dni, sc, prog)) {
			System.out.println("Introduce el tanto % aumentar el salario.");
			porcentaje = sc.nextDouble();
			for(Empleado p: prog) {
				if (p.getDni().equals(dni)) {
					p.aumentarSalario(porcentaje);
					break;
				}
			}

			System.out.println("Salario aumentado.");
			System.out.println();
		}
		else{
			System.out.println("El empleado no existe.");	
			System.out.println();
		}
	}
	
	public static void mostrarLista(ArrayList <Empleado> prog){
		for(Empleado p: prog) {
			System.out.println(p.toString());
			p.mostrarClasificacion();
		}
		System.out.println();
	}

}
