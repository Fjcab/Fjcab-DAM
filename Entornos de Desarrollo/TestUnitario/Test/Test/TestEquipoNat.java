package Test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import NatacionS.NatSinc;

@RunWith(Parameterized.class)



public class TestEquipoNat {
	private String dni, nombre, fecha;
	private int edad, dorsal, puntuacion, dificultad;
	int resultado;


	public TestEquipoNat(String dni, String nombre,int edad, String fecha, int dorsal, int puntuacion, int dificultad, int resultado) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad=edad;
		this.fecha = fecha;
		this.dorsal = dorsal;
		this.puntuacion = puntuacion;
		this.dificultad = dificultad;
		this.resultado = resultado;
	}
	
	@Parameters
	public static Collection<Object[]> datos(){
		return Arrays.asList(new Object [][] {{"01234567A", "Marta", 18, "01-01-2024", 1, 5, 3, 15},
			{"12345678B", "Maria", 15, "01-01-2024", 23, 8, 5, 40}, {"23456789C", "Elena",21 , "02-02-2024", 7, -1, 3, -3}});
		
	}
	
	@Test
	public void TestPuntuacion() {
		NatSinc equipo =new NatSinc (dni, nombre, edad, fecha, dorsal, puntuacion, dificultad); 
		int result=equipo.puntuacionFinal(puntuacion, dificultad);
		assertEquals("Error",resultado,result);
	}
	@Test
	public void TestEdad() {
		NatSinc equipo =new NatSinc (dni, nombre, edad, fecha, dorsal, puntuacion, dificultad); 
		boolean result=equipo.mayorEdad(edad);
		assertTrue("No es mayor", result);
	}

}
