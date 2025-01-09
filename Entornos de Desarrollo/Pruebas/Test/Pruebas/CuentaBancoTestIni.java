package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CuentaBancoTestIni { // creo la clase Test

	@Test
	public void testIngresar() {
		CuentaBanco cuenta = new CuentaBanco(1500, "abc123"); // Creo el objeto de la clase
		int resultado = cuenta.ingresar(500); // ejecuto el método ingresar con 500 y lo almaceno en resultado
		assertEquals("fallo al ingresar", 2000, resultado); // si falla me pone el texto, 2000 es lo que tiene que sali
															// y resultado es mi variable anterior
	}

	@Test
	public void testRetirar() { //mismo método que el anterior pero para retirar
		CuentaBanco cuenta = new CuentaBanco(1500, "abc123");// Creo el objeto de la clase
		int resultado = cuenta.retirar(500, "abc123");
		assertEquals("fallo de prueba (retirar)", 1000, resultado);
	}

	@Test
	public void testPasswordCorrecta() {
		CuentaBanco cuenta = new CuentaBanco(1500, "abc123"); // Creo el objeto de la clase
		boolean resultado = cuenta.passwordCorrecta("abc123");
		assertTrue("No es true", resultado);
	}
}
