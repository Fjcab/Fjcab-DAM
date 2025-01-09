package carreraGalgos;

public class GalgoH extends Thread{

	private String nombre;
	private int tiempo;
	
	protected GalgoH(String nombre) {
		this.nombre = nombre;
		this.tiempo = 0;
	}
	
	
	protected String getNombre() {
		return nombre;
	}


	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}


	protected int getTiempo() {
		return tiempo;
	}


	protected void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}


	public void run() {
		try {
			System.out.printf("El galgo %s ha salido.%n", nombre);
			Thread.sleep(tiempo*1000);
			System.out.printf("El galgo %s ha llegado.%n", nombre);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
	}
	
}
