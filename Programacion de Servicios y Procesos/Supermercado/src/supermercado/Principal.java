package supermercado;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		Random rnd = new Random();
		int numClientes = rnd.nextInt(70)+30;
		
		Cliente clientela [] = new Cliente[numClientes];
		for (int i = 0; i < numClientes; i++) {
			clientela [i] = new Cliente(i);
			clientela [i].start();	
		}
		
		for (int i = 0; i < numClientes; i++) {
			try {
				clientela [i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
		
		System.out.println();
        System.out.println("Informe:");
        System.out.println("Clientes: " + numClientes + ".");
        System.out.println("Clientes atendidos: " + Supermercado.getClientes() + ".");
        System.out.println("Recaudación Total: " + Math.round(Supermercado.getRecaudacion()*100d)/100d + "€.");
        System.out.println("Recaudación Caja 1: " + Math.round(Supermercado.getRecaudacionCaja1()*100d)/100d + "€.");
        System.out.println("Recaudación Caja 2: " + Math.round(Supermercado.getRecaudacionCaja2()*100d)/100d + "€.");
        System.out.println("Recaudación Caja 3: " + Math.round(Supermercado.getRecaudacionCaja3()*100d)/100d + "€.");
	}

}
