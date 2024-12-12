package hilos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String opcion = null;

		do {
			/*Como se pueden crear los hilos mediante herencia y mediante interfaz he creado las clases de ambas formas
				dado la opcion al usuario de cual elegir.*/ 
			System.out.printf("¿Que quieres usar?%n1.Herencia%n2.Interfaz%n");
			opcion = sc.next();
			switch (opcion) {
			case "1":
				herencia();
				break;
			case "2":
				interfaz();
				break;
			default:
				System.out.printf("Introduce 1 o 2.%n");
			}
		} while (!opcion.equals("1") && !opcion.equals("2"));
	}
	
    private static void herencia() {
    	//Instanciamos los hilos.
    	HiloParesH hiloPares1 = new HiloParesH("Hilo Pares 1");
		HiloParesH hiloPares2 = new HiloParesH("Hilo Pares 2");
		HiloImparesH hiloImpares1 = new HiloImparesH("Hilo Impares 1");
		HiloImparesH hiloImpares2 = new HiloImparesH("Hilo Impares 2");
		//Iniciamos los hilos.
		hiloPares1.start();
		hiloPares2.start();
		hiloImpares1.start();
		hiloImpares2.start();
		try {
			//Usamos el join para que el código no continue hasta que terminen todos los hilos.
			hiloPares1.join();
			hiloPares2.join();
			hiloImpares1.join();
			hiloImpares2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Una vez han terminado podemos hacer lo que queramos con los hilos. En este caso he sumado los resultados.
		int sumaPares = hiloPares1.getSuma()+hiloPares2.getSuma();
		int sumaImpares = hiloImpares1.getSuma()+hiloImpares2.getSuma();
		int sumaTotal = sumaPares+sumaImpares;
		resultados(sumaPares, sumaImpares, sumaTotal);
    }
    
    private static void interfaz() {
    	//Instanciamos los hilos.
		HiloParesI hiloParesA = new HiloParesI("Hilo Pares 1");
		HiloParesI hiloParesB = new HiloParesI("Hilo Pares 2");
		HiloImparesI hiloImparesA = new HiloImparesI("Hilo Impares 1");
		HiloImparesI hiloImparesB = new HiloImparesI("Hilo Impares 2");
		
		//Tenemos 2 opciones:
		//1º Creamos un ArrayList de tipo Thread con todos los hilos.
		ArrayList<Thread> hilos = new ArrayList<>();
		hilos.add(new Thread(hiloParesA));
		hilos.add(new Thread(hiloParesB));
		hilos.add(new Thread(hiloImparesA));
		hilos.add(new Thread(hiloImparesB));

        // Iniciamos los hilos.
        for (Thread thread : hilos) {
            thread.start();
        }

      //Usamos el join para que el código no continue hasta que terminen todos los hilos.
        for (Thread thread : hilos) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            /*
      	//2º Creamos por cada hilo un objeto de tipo Thread .
		Thread threadParesA = new Thread(hiloParesA);
		Thread threadParesB = new Thread(hiloParesB);
		Thread threadImparesA = new Thread(hiloImparesA);
		Thread threadImparesB = new Thread(hiloImparesB);
		
		// Iniciamos los hilos.
		threadParesA.start();
		threadParesB.start();
		threadImparesA.start();
		threadImparesB.start();
		
		//Usamos el join para que el código no continue hasta que terminen todos los hilos.
		try {
			threadParesA.join();
			threadParesB.join();
			threadImparesA.join();
			threadImparesB.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
        
      //Una vez han terminado podemos hacer lo que queramos con los hilos. En este caso he sumado los resultados.
		int sumaPares = hiloParesA.getSuma()+hiloParesB.getSuma();
		int sumaImpares = hiloImparesA.getSuma()+hiloImparesB.getSuma();
		int sumaTotal = sumaPares+sumaImpares;
		resultados(sumaPares, sumaImpares, sumaTotal);
    }
    
    private static void resultados(int sumaPares, int sumaImpares, int sumaTotal) {
    	System.out.printf("Todos los hilos han terminado.%n");
    	System.out.printf("Los hilos pares suman %s.%n", sumaPares);
    	System.out.printf("Los hilos impares suman %s.%n", sumaImpares);
    	System.out.printf("Todos los hilos suman %s.%n", sumaTotal);
    }
}
