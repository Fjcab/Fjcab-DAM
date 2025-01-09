package parque;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Parque {
	static Random rnd = new Random();
	private static Semaphore puerta1 = new Semaphore(1);
	private static Semaphore puerta2 = new Semaphore(1);
	private static Semaphore puerta3 = new Semaphore(1);
	private static Semaphore puerta4 = new Semaphore(1);
	private static Semaphore puerta5 = new Semaphore(1);
	private static int  sumaVisitantes = 0;
	private static int  sumaPuerta1 = 0;
	private static int  sumaPuerta2 = 0;
	private static int  sumaPuerta3 = 0;
	private static int  sumaPuerta4 = 0;
	private static int  sumaPuerta5 = 0;
	private int nombre;

	public static void puertas(int id){
		int puerta = rnd.nextInt(5)+1;
		int tiempo = rnd.nextInt(3000)+1000;
		try {
			Thread.sleep(tiempo);
		switch(puerta) {
		case 1:
			puerta1.acquire();
			setSumaPuerta1(getSumaPuerta1() + 1);
			break;
		case 2:
			puerta2.acquire();
			setSumaPuerta2(getSumaPuerta2() + 1);
			break;
		case 3:
			puerta3.acquire();
			setSumaPuerta3(getSumaPuerta3() + 1);
			break;
		case 4:
			puerta4.acquire();
			setSumaPuerta4(getSumaPuerta4() + 1);
			break;
		case 5:
			puerta5.acquire();
			setSumaPuerta5(getSumaPuerta5() + 1);
			break;
		}
		
		System.out.println(id + " ha pasado por la entrada " + puerta);
		setSumaVisitantes(getSumaVisitantes() + 1);
		
		switch(puerta) {
		case 1:
			puerta1.release();
			break;
		case 2:
			puerta2.release();
			break;
		case 3:
			puerta3.release();
			break;
		case 4:
			puerta4.release();
			break;
		case 5:
			puerta5.release();
			break;
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

	public static int getSumaVisitantes() {
		return sumaVisitantes;
	}

	public static void setSumaVisitantes(int sumaVisitantes) {
		Parque.sumaVisitantes = sumaVisitantes;
	}

	public static int getSumaPuerta1() {
		return sumaPuerta1;
	}

	public static void setSumaPuerta1(int sumaPuerta1) {
		Parque.sumaPuerta1 = sumaPuerta1;
	}

	public static int getSumaPuerta2() {
		return sumaPuerta2;
	}

	public static void setSumaPuerta2(int sumaPuerta2) {
		Parque.sumaPuerta2 = sumaPuerta2;
	}

	public static int getSumaPuerta3() {
		return sumaPuerta3;
	}

	public static void setSumaPuerta3(int sumaPuerta3) {
		Parque.sumaPuerta3 = sumaPuerta3;
	}

	public static int getSumaPuerta4() {
		return sumaPuerta4;
	}

	public static void setSumaPuerta4(int sumaPuerta4) {
		Parque.sumaPuerta4 = sumaPuerta4;
	}

	public static int getSumaPuerta5() {
		return sumaPuerta5;
	}

	public static void setSumaPuerta5(int sumaPuerta5) {
		Parque.sumaPuerta5 = sumaPuerta5;
	}

}
