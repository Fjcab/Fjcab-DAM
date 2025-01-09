package deposito;

public class ControlDeposito {

	public static void main(String[] args) {
		Deposito deposito = new Deposito();
		Thread llenado = new Thread(new Llenado(deposito));
		Thread vaciado = new Thread(new Vaciado(deposito));
		System.out.println("El depósito se está llenando.");
		System.out.println();
		llenado.start();
		vaciado.start();

	}

}
