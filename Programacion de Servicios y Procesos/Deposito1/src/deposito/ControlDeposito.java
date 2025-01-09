package deposito;

public class ControlDeposito {

	public static void main(String[] args) {
		Deposito deposito = new Deposito();
		Thread llenado = new Thread(new Llenado(deposito));
		Thread vaciado = new Thread(new Vaciado(deposito));
		
		llenado.start();
		vaciado.start();

	}

}
