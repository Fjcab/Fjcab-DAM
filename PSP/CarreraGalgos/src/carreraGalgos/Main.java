package carreraGalgos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String opcion=null, tiempo=null;
		ArrayList<GalgoH>lista1=new ArrayList <GalgoH>();
		ArrayList<GalgoI>lista2=new ArrayList <GalgoI>();
		ListaGalgos l = new ListaGalgos();
		l.listaGalgos1(lista1);
		l.listaGalgos2(lista2);
		
		
		System.out.printf("Introduce el tipo de carrera:%n1. Carrera de machos(Herencia)%n2. Carrera de hembras(Interfaz)%n");
		do {
		opcion = sc.next();
		switch(opcion) {
			case "1":
				System.out.printf("Introduce el tiempo que tarda en llegar cada galgo:%n");
			for (int i=0; i<lista1.size() ;i++) {		
				do {		
					try {		
						System.out.printf("%s tarda en llegar:%n",lista1.get(i).getNombre());
						tiempo = sc.next();
						lista1.get(0).setTiempo(Integer.valueOf(tiempo));
					} catch(NumberFormatException e){
						System.out.println("Introduce un numero entero");
					}
				}while (!isNumeric(tiempo));
			}
			lista1.get(0).start();
			lista1.get(1).start();
			lista1.get(2).start();
			lista1.get(3).start();
			lista1.get(4).start();
			lista1.get(5).start();
				break;
			case "2":
				System.out.printf("Introduce el tiempo que tarda en llegar cada galgo:%n");
			for (int i=0; i<lista2.size() ;i++) {		
				do {	
					try {		
						System.out.printf("%s tarda en llegar:%n",lista2.get(i).getNombre());
						tiempo = sc.next();
						lista2.get(0).setTiempo(Integer.valueOf(tiempo));
					} catch(NumberFormatException e){
						System.out.println("Introduce un numero entero");
					}
				}while (!isNumeric(tiempo));
			}
			new Thread (lista2.get(0)).start();
			new Thread (lista2.get(1)).start();
			new Thread (lista2.get(2)).start();
			new Thread (lista2.get(3)).start();
			new Thread (lista2.get(4)).start();
			new Thread (lista2.get(5)).start();
				break;
			default:
				System.out.printf("Introduce 1 o 2.%n");	
		}
		}while(!opcion.equals("1") && !opcion.equals("2"));
	}
	
	protected static boolean isNumeric(String str){
		return str != null && str.matches("[0-9]+");
	}

}
