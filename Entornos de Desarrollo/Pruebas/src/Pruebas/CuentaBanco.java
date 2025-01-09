package Pruebas;

public class CuentaBanco { // me creo la clase cuentabanco
	private int saldo; // con sus valores
	private String password;

	public CuentaBanco(int saldoInicial, String password) { // Realizo el constructor
		saldo = saldoInicial;
		this.password = password;
	}

	public int ingresar(int cantidad) { // método para añadir la cantidad a mi saldo
		if (cantidad > 0) {
			saldo += cantidad;
			return saldo;
		} else
			return -1;
	}

	public int retirar(int cantidad, String pass) { // método para retirar la cantidad a mi saldo
		if (passwordCorrecta(pass)) {
			if (saldo >= cantidad) {
				saldo -= cantidad;
				return saldo;
			} else
				return -1;
		} else
			return -2;
	}

	public boolean passwordCorrecta(String pass) {  // comprueba la password
		return password.equals(pass);
	}
}
