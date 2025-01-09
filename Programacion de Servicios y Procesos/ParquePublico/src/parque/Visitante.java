package parque;

public class Visitante extends Thread{
	private final int id;

	
    public Visitante(int id) {
        this.id = id;
    }
	
    public void run() {
            Parque.puertas(id);
    }

}
