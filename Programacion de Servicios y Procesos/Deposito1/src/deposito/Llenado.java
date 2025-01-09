package deposito;

public class Llenado implements Runnable {
	Deposito deposito;

	protected Llenado(Deposito deposito) {
		this.deposito = deposito;
	}

	@Override
	public void run() {
		while(true) {
			try {
				deposito.llenarDeposito();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
