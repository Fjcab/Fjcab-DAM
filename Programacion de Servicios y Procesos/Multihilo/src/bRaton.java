
public class bRaton extends Thread {

	private String nombre;
	private int tiempoAlimentacion;
	
	public bRaton(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempo;
	}
	
	public void run() { // obligatorio metodo run
		try {		
		System.out.printf("El raton %s ha comenzado a alimentarse%n", nombre); //%s = nombre. %n = salto de linea
		Thread.sleep(tiempoAlimentacion * 1000); //Pausa la ejecución del hilo. Milisegundos
		System.out.printf("El raton %s ha terminado de alimentarse%n", nombre);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

public static void main(String[] args) {
	bRaton fievel = new bRaton("Fievel", 4);
	bRaton jerry = new bRaton("Jerry", 5);
	bRaton pinky = new bRaton("Pinky", 3);
	bRaton mickey = new bRaton("Mickey", 6);
	fievel.start(); //.start para lanzar el metodo run
	jerry.start();
	pinky.start();
	mickey.start();
	//cada raton comienza a comer de inmediato
	}
}

