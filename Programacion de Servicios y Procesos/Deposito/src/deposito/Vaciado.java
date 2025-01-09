package deposito;

public class Vaciado implements Runnable  {
	Deposito deposito;

	protected Vaciado(Deposito deposito) {
		this.deposito = deposito;
	}

	@Override
	public void run() {
		while(true) {
			try {
				deposito.vaciarDeposito();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
