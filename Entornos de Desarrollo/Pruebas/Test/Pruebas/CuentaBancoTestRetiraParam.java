package Pruebas;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CuentaBancoTestRetiraParam {

	private String passwordInicial, passwordPrueba;
	private int saldoInicial, cantidadRetirada;
	private int resultado;

	public CuentaBancoTestRetiraParam(String passwordInicial, String passwordPrueba, int saldoInicial, int cantidadRetirada, int resultado) {
		this.passwordInicial = passwordInicial;
		this.passwordPrueba = passwordPrueba;
		this.saldoInicial = saldoInicial;
		this.cantidadRetirada = cantidadRetirada;
		this.resultado = resultado;
	}

	@Parameters
	public static Collection<Object[]> datos() {
		return Arrays.asList(new Object[][] { 
			{ "pass123", "pass123", 1500, 500, 1000 }, 
			{ "pass123", "pass123", 1500, 2000, -1 },
			{ "pass123", "pass", 1500, 500, -2 },
			{ "pass123", "pass", 1500, 2000, -2 }
		});
	}

	@Test
	public void testRetirar() {
		CuentaBanco cuenta2 = new CuentaBanco(saldoInicial, passwordInicial);
		int result = cuenta2.retirar(cantidadRetirada,passwordPrueba);
		assertEquals(resultado, result);
	}
}
