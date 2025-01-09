package supermercado;

import java.util.Random;

public class Cliente extends Thread{
	
	int id;
	double dinero;
	
	public Cliente(int id) {
		this.id = id+1;
		Random rnd = new Random();
		this.dinero = Math.round((rnd.nextDouble(130) + 20) * 100d ) / 100d;
		}
	
    public void run() {
        Supermercado.cajas(id, dinero);
        }
}
