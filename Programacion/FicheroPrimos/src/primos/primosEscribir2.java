package primos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class primosEscribir2 {

	public static void main(String[] args) {
		String nombre ="Archivo Primos.txt";
		String contenido;

        
	    for(int x = 2; x <= 500; x++){
	        if(esPrimo(x)){
	            contenido=(String.valueOf(x)+" es primo.\n");
	            escribirPrimos(nombre,contenido);
	        }
	    }

	}
	public static boolean esPrimo(int numero){
	    int contador = 2;
	    boolean primo=true;
	    while ((primo) && (contador!=numero)){
	      if (numero % contador == 0)
	            primo = false;
	      contador++;
	    }
	    return primo;
	}
	
	public static void escribirPrimos(String nombre, String contenido) {
		try {
			BufferedWriter writer =new BufferedWriter(new FileWriter(nombre, true)) ;
			writer.write(contenido);
			writer.close();
			System.out.println("Archivo escrito correctamente");
		} catch (IOException e) {
			System.err.println("Error"+e.getMessage());
		}
	}	
}
