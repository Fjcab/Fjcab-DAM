
public class cRaton implements Runnable {

	private String nombre;
	private int tiempoAlimentacion;
	
	public cRaton(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempo;
	}
	
	public void comer() { // podemos llamar al metodo run directamente
		try {		
		System.out.printf("El raton %s ha comenzado a alimentarse%n", nombre); //%s = nombre. %n = salto de linea
		Thread.sleep(tiempoAlimentacion * 1000); //Pausa la ejecución del hilo. Milisegundos
		System.out.printf("El raton %s ha terminado de alimentarse%n", nombre);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.comer();
	}
	
	
	

public static void main(String[] args) {
	cRaton fievel = new cRaton("Fievel", 4);
	cRaton jerry = new cRaton("Jerry", 5);
	cRaton pinky = new cRaton("Pinky", 3);
	cRaton mickey = new cRaton("Mickey", 6);
	new Thread(fievel).start(); //.start para lanzar el metodo run
	new Thread(jerry).start();
	new Thread(pinky).start();
	new Thread(mickey).start();

	//cada raton comienza a comer de inmediato
	}
}

