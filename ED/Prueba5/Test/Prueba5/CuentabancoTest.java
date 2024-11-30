package Prueba5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CuentabancoTest {

	@Test
	public void testIngersar() {
		CuentaBanco cuenta = new CuentaBanco(1500,"abc123");
		int resultado=cuenta.ingresar(500,"abc123");
		assertEquals(-1,1000,resultado);
	}
	@Test
	public void testRetirar() {
		CuentaBanco cuenta = new CuentaBanco(1500,"abc123");
		int resultado=cuenta.ingresar(500,"abc123");
		assertEquals(-1,1000,resultado);
		
	}
	
	@Test
	public void testPasswordCorrecta() {
		CuentaBanco cuenta = new CuentaBanco(1500,"abc123");
		boolean resultado=cuenta.passwordCorrecta("abc123");
		assertTrue(resultado);
	}
}
