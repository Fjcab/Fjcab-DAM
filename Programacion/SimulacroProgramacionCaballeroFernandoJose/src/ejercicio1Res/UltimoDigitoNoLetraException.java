package ejercicio1Res;

public class UltimoDigitoNoLetraException{
	public static void validarDNI2(String dni) throws IllegalArgumentException {
	    char ultimoChar = dni.charAt(8);
	    if (!Character.isLetter(ultimoChar)) {
	        throw new IllegalArgumentException("El último dígito del DNI siempre debe de ser una letra.");
	    }
	}
}