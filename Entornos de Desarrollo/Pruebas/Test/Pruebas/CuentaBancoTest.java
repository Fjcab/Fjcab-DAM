package Pruebas;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CuentaBancoTest {

	CuentaBanco cuenta; //Creo el objeto cuenta de cuenta banco

	@BeforeClass // esto la hace antes de crear la clase y antes de ningún test, y anuncio las
					// pruebas
	public static void inicioPruebas() {
		System.out.println("iniciando las pruebas de clase!!!!");
	}

	@AfterClass // esta clase lo va hacer al finalizar todos los test y las clases, y anuncio el final de
				// las pruebas
	public static void finPruebas() {
		System.out.println("finalizando las pruebas de clase. FIN!!!");
	}

	@Before  // antes de los test pongo el before y me crea el objeto para no tener que crearlo 
	public void creaCuentaBanco() {
		
		cuenta = new CuentaBanco(1500, "abc123");
		System.out.println("probando m�todo");
	}

	@After
	public void borraCuentaBanco() {
		cuenta = null;
		System.out.println("fin prueba de m�todo");
	}

	@Test
	public void testIngresar() {
		//CuentaBanco cuenta = new CuentaBanco(1500, "abc123");
		int resultado = cuenta.ingresar(500);
		assertEquals("fallo al ingresar", 2000, resultado);
	}

	@Test
	public void testRetirar() {
		//CuentaBanco cuenta = new CuentaBanco(1500, "abc123");
		int resultado = cuenta.retirar(500, "abc123");
		assertEquals("fallo de prueba (retirar)", 1000, resultado);
	}

	@Test
	public void testPasswordCorrecta() {
		//CuentaBanco cuenta = new CuentaBanco(1500, "abc123");
		boolean resultado = cuenta.passwordCorrecta("abc123");
		assertTrue("No es true", resultado);
	}
}
