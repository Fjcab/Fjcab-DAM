package Pruebas;

import org.junit.runner.RunWith;  // Ejecuto todos los Test
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CuentaBancoTest.class, CuentaBancoTestIngresaParam.class, CuentaBancoTestIni.class,
		CuentaBancoTestRetiraParam.class })
public class AllTests {
}
