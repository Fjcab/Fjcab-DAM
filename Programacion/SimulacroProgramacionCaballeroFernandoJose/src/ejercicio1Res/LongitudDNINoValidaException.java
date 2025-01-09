package ejercicio1Res;

public class LongitudDNINoValidaException {
	
	public static void validarDNI(String dni) throws IllegalArgumentException {
	    if (dni.length() != 9) {
	        throw new IllegalArgumentException("La longitud del dni debe ser de 9 caracteres");
	    }
	}
	
}
