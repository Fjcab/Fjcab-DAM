package PrimerProyectoObjetos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		//NombreDelaclase nombre del objeto = new nombreConstructor(atributos)
		alumnos a1=new alumnos();
		alumnos a2=new alumnos("123","Javier","Navazo","456","jn@gmail.com",12);
		alumnos a3=new alumnos("234","Fernando","Caballero");
		alumnos a4=new alumnos();
		
		System.out.println("El dni del alumno 1 es: "+a1.getDni());
		a1.setDni("09876H");
		System.out.println("El dni del alumno 1 es: "+a1.getDni());
		System.out.println("El dni del alumno 2 es: "+a2.getDni());
		System.out.println("El dni del alumno 3 es: "+a3.getDni());
		System.out.println("Dime el dni:");
		a4.setDni(sc.next());
		System.out.println("El dni del alumno 4 es: "+a4.getDni());
	}

}
