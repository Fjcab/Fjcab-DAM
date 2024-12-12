package Ejercicio1;

public class UltimoDigitoNoLetraException {
	public static void comprobarDNI(String dni) throws IllegalArgumentException {
	    if (Character.isDigit(dni.charAt(8))) {
	        throw new IllegalArgumentException("El DNI acabar en letra.");
	    }
	    //Creamos la excepcion para comprobar que acaba en letra
	}
}
