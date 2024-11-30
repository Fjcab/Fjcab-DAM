package Prueba5;

public class CuentaBanco {
	
	private int saldo;
	private String password;
	
	public CuentaBanco (int saldoInicial, String password) {
		this.saldo=saldoInicial;
		this.password=password;
	}
	public int ingresar (int cantidad, String pass) {
		if (cantidad > 0) {
				saldo+=cantidad;
				return saldo;
			}else
				return -1;
		}
	public int retirar (int cantidad, String pass) {
		//if (password.equals(pass)){
		if (passwordCorrecta(pass)) {
			if (saldo>=cantidad) {
				saldo-=cantidad;
				return saldo;
			}else
				return -1;
		}else 
			return -2;
	}
	public boolean passwordCorrecta (String pass) {
		return password.equals(pass);
	}

}
