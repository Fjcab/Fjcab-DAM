package bebedero;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Bebedero {
	private static Semaphore bebedero = new Semaphore(3);
	private static double aguaTotal = 0;
	
	protected static double getAguaTotal() {
		double agual = aguaTotal/10000;
		return agual;
	}

	public static void beber(Perro perro){
		Random rd = new Random();
		int tiempo = rd.nextInt(1000)+1000;
		try {
			bebedero.acquire();
			System.out.println("El perro " + perro.getNombre() + " esta bebiendo.");
			int agua = tiempo*perro.getBeber();
			Thread.sleep(tiempo);
			System.out.println("El perro " + perro.getNombre() + " ha bebido " + agua+".");
			aguaTotal += agua;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		bebedero.release();
		System.out.println();
		System.out.println("El perro " + perro.getNombre() + " ha salido.");
		System.out.println();
		
	}

}
