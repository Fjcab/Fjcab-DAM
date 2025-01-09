package donaciones;

import java.util.Random;

public class Principal {

	 public static void main(String[] args) {
		 Random rd = new Random();
		 int numeroDeDonantes = rd.nextInt(5)+15;

	        Thread[] donantesThreads = new Thread[numeroDeDonantes];

	        for (int i = 0; i < numeroDeDonantes; i++) {

	            double cantidadDonada = rd.nextDouble(1)+100;
	            donantesThreads[i] = new Thread(new Donante(cantidadDonada));
	            donantesThreads[i].start();
	        }

	        for (Thread donanteThread : donantesThreads) {
	            try {
	                donanteThread.join();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }

	        System.out.println("\n--- Resultados ---");
	        System.out.println("Cantidad total de donantes: " + Cuenta.getDonantes());
	        System.out.println("Cantidad total recaudada: " + Cuenta.getTotalRecaudado() + " euros");
	    }
	}


