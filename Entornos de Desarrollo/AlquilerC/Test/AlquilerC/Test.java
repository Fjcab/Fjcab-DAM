package AlquilerC;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)

public class Test {
	@org.junit.jupiter.api.Test
	void test() {
		fail("Not yet implemented");
	}
		
	private int precioDiario;
	private int descuento;
	private int numeroDias;
	private int precioTotal;

public Test (int precioDiario, int descuento, int numeroDias, int precioTotal)
{
	
	this.precioDiario=precioDiario;
	this.descuento=descuento;
	this.numeroDias=numeroDias;
	this.precioTotal=precioTotal;
}
@Parameters

public static Collection<Object[]> datos(){
	return Arrays.asList(new Object[][] {
		
	{12,43,5,45}, {12,34,5,-1}, {3,3,1,8}}
);
}
}

