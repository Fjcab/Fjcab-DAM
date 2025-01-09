package supermercado;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Supermercado {
	
	static Random rnd = new Random();
	private static Semaphore supermercado = new Semaphore (15);
	private static Semaphore caja1 = new Semaphore (1);
	private static Semaphore caja2 = new Semaphore (1);
	private static Semaphore caja3 = new Semaphore (1);
	private static double recaudacion;
	private static double recaudacionCaja1;
	private static double recaudacionCaja2;
	private static double recaudacionCaja3;
	private static int clientes;
	
	public static void cajas(int id, double dinero){
		
		int tiempo = rnd.nextInt(3000)+1000;
		int tiempoCaja = rnd.nextInt(200)+1000;
		
		try {
			Thread.sleep(tiempo);
			supermercado.acquire();
			System.out.println("El cliente "+id + " ha entrado a la tienda.");
			boolean cajaAdquirida = false;
			while(!cajaAdquirida) {	
				if(caja1.tryAcquire()) {				
					Thread.sleep(tiempoCaja);
					recaudacionCaja1 +=dinero;
					System.out.println(id + " pasa por la caja 1.");
					System.out.println(id + " gasta " + dinero+"€.");
					caja1.release();
					clientes +=1;
					cajaAdquirida = true;
					}else{
						if(caja2.tryAcquire()) {				
							Thread.sleep(tiempoCaja);
							recaudacionCaja2 +=dinero;
							System.out.println(id + " pasa por la caja 2.");
							System.out.println(id + " gasta " + dinero+"€.");
							caja2.release();
							clientes +=1;
							cajaAdquirida = true;		
							}else{
								if(caja3.tryAcquire()) {				
									Thread.sleep(tiempoCaja);
									recaudacionCaja3 +=dinero;
									System.out.println(id + " pasa por la caja 3.");
									System.out.println(id + " gasta " + dinero+"€.");
									caja3.release();
									clientes +=1;
									cajaAdquirida = true;
									}
								}
					}
				}
			
			recaudacion +=dinero;
			supermercado.release();
			System.out.println("El cliente " + id + " sale de la tienda.");
			} catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
	
	protected static double getRecaudacion() {
		return recaudacion;
	}
	
	protected static double getRecaudacionCaja1() {
		return recaudacionCaja1;
	}
	
	protected static double getRecaudacionCaja2() {
		return recaudacionCaja2;
	}
	
	protected static double getRecaudacionCaja3() {
		return recaudacionCaja3;
	}
	
	protected static int getClientes() {
		return clientes;
	}
}

