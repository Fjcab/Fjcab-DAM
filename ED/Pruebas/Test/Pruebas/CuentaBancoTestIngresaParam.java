package Pruebas;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class) // creo la clase parametrizadas, y poder crear una rray para poder probar varios
								// valores en un solo test
public class CuentaBancoTestIngresaParam { // creo la clase Test Junit con las variables que voy a necesitare
	private String passwordInicial;
	private int saldoInicial, cantidadDepositada;
	private int resultado;

	public CuentaBancoTestIngresaParam(String passwordInicial, int saldoInicial, int cantidadDepositada,
			int resultado) { // creo el constructor de la clase anterior
		this.passwordInicial = passwordInicial;
		this.saldoInicial = saldoInicial;
		this.cantidadDepositada = cantidadDepositada;
		this.resultado = resultado;
	}

	@Parameters
	public static Collection<Object[]> datos() { // Creo una colección que almaceno en un arraylist con las cuantro
													// valores que antes definí y los valores para realizar mi test
		return Arrays.asList(new Object[][] { { "pass123", 1500, 500, 2000 }, { "pass123", 1500, 0, -1 },
				{ "pass123", 1500, -500, -1 } });
	}

	@Test
	public void testIngresar() { // Test del método ingresar, lo va a probar con todos los valores de mi
									// colección
		CuentaBanco cuenta = new CuentaBanco(saldoInicial, passwordInicial);// Creo el objeto de la clase Cuentabanco
																			// con los valores parametrizados, son
																			// genéricos, va a ir tomando los de la
																			// colección.
		int result = cuenta.ingresar(cantidadDepositada);// aquí el valor de la variable seá cada vez el de la colección.
		assertEquals("fallo al ingresar", resultado, result);// result es la variable que me devuelve el método y resultado es el de la colección.
	} // Como en el método del primer test
}
