package Ejercicio1;

public class LongitudDNINoValidaException {
	
	public static void validarDNI(String dni) throws IllegalArgumentException {
	    if (dni.length() != 9) {
	        throw new IllegalArgumentException("El DNI debe de tener 9 caracteres");
	        //Creamos la excepcion para comprobar numero de digitos
	    }
	}
	
}
